const name = document.getElementById('name')
const surname = document.getElementById('surname')
const room = document.getElementById('room')

fetch('http://localhost:8000/api/rezervacija_tip')
    .then(rsp =>rsp.json())
    .then(tipRezervacijeData=>{
        tipRezervacijeData.forEach(tipRezervacije=>{
            const option = document.createElement('option')
            option.value = tipRezervacije.id
            option.text = tipRezervacije.name
            tipRezervacije.appendChild(option)
        })
        ocument.getElementById('save').addEventListener('click', ()=>{
            if(name.value == null || name.value == ''){
                alert('Ime ne sme biti prazno')
                return
            }
            if(surname.value == null || surname.value == ''){
                alert('Prezime ne sme biti prazno')
                return
            }
            if(room.value == null || room.value == ''){
                alert('Broj soba ne sme biti prazno')
                return
            }

            fetch('http:localhost:8000/api/rezervacija', {
                method:'POST',
                headers:{
                    'Content-Type': 'aplication/json'
                },
                body:JSON.stringify({
                    name:name.value,
                    surname: surname.value,
                    room: room.value,
                    tipRezervacijeId:tipRezervacije.value
                })
            }).then(rsp =>{
                if(rsp.ok){
                    window.location.href = './index.html'
                }
                alert(`Dodavanje rezervacije nije uspelo(HTTP${rsp.status})`)
            })
        })

    })

