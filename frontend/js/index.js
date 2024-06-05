const table = document.getElementById('table')
const template = document.getElementById("rezervacija")

  fetch('http://localhost:8000/api/rezervacija')
    .then(rsp => rsp.json())
    .then(data => {
      data.forEach(rezervacija => {
        const copy = template.content.cloneNode(true);
        copy.querySelector(".id").innerText = rezervacija.id;
        copy.querySelector(".name").innerText = rezervacija.name;
        copy.querySelector(".surname").innerText = rezervacija.surname;
        copy.querySelector(".room").innerText = rezervacija.room;
          copy.querySelector(".reservation").innerText = rezervacija.rezervacijaTip.name
        copy.querySelector(".created").innerText = formatDate(rezervacija.createdAt)
          copy.querySelector(".updated").innerText = formatDate(rezervacija.updatedAt)
        copy.querySelector(".edit").href = `./edit.html?id=${rezervacija.id}`;
        copy.querySelector(".remove").addEventListener('click',()=>{
           if (confirm(`Zelite obrisati rezervaciju ${rezervacija.name} ${rezervacija.surname} ${rezervacija.room}`)){
            fetch(`http://localhost:8000/api/rezervacija/${data.id}` , {
              method : 'DELETE',
          })
          .then(rsp =>{
              if(rsp.status == 204 ){
                  window.location.href = './index.html'
                  return
              }
              alert(`Brisanje rezervacije nije uspelo(HTTP${rsp.status})`)
          })
           }
        })
        table.appendChild(copy);
      });
    })
  
    




