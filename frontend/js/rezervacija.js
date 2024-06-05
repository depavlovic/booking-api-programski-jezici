const table = document.getElementById('rezervacija_tip_table')
const template = document.getElementById('rezervacija_tip')



fetch('http://localhost:8000/api/rezervacija_tip')
    .then(rsp => rsp.json())
    .then(data => {
        data.forEach(rezervacija_tip => {
            const copy = template.content.cloneNode(true);
            copy.querySelector(".id").innerText = rezervacija_tip.id;
            copy.querySelector(".name").innerText = rezervacija_tip.name;
            copy.querySelector(".created").innerText = formatDate(rezervacija_tip.createdAt)
            copy.querySelector(".updated").innerText = formatDate(rezervacija_tip.updatedAt)
            copy.querySelector(".edit").href = `./edit_rezervacija_tip.html?id=${rezervacija_tip.id}`;
            copy.querySelector(".remove").addEventListener('click',()=>{
                if (confirm(`Zelite obrisati Tiprezervacije ${rezervacija_tip.name}`)){
                    fetch(`http://localhost:8000/api/rezervacija_tip/${data.id}` , {
                       method : 'DELETE',
                    })
                       .then(rsp =>{
                            if(rsp.status === 204 ){
                                window.location.href = './rezervacija_tip.html'
                                return
                            }
                            alert(`Brisanje Tiparezervacije nije uspelo(HTTP${rsp.status})`)
                        })
                }
            })
            table.appendChild(copy);
        });
    })