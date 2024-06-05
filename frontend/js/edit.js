const id = params.get('id')
if(id == null || id == '')
    window.location.href= './index.html'

const breadcrumb = document.getElementById('breadcrumb')
const sid = document.getElementById('id')
const name = document.getElementById('name')
const surname = document.getElementById('surname')
const room = document.getElementById('room')
const tipRezervacije = document.getElementById('tipRezervacije')
const created = document.getElementById('created')
const updated = document.getElementById('updated')


fetch('http://localhost:8000/api/rezervacija_tip')
    .then(rsp =>rsp.json())
    .then(data=>{
        dataForEach(tipRezervacije=>{
            const option = document.createElement('option')
            option.value = tipRezervacije.id
            option.text = tipRezervacije.name
            tipRezervacije.appendChild(option)
        })

    })



fetch('http://localhost:8000/api/rezervacija/' + id)
.then(rsp=>{
    if(rsp.status==200)
        return rsp.json()

})
.then(data=>{
    breadcrumb.innerText = `${data.name} ${data.surname}`
    sid.value = data.id
    name.value = data.name
    surname.value = data.surname
    room.value = data.room

    //Ucitavanje tipaRezervacije
    fetch('http://localhost:8000/api/rezervacija_tip')
        .then(rsp =>rsp.json())
        .then(tipRezervacijeData=>{
            tipRezervacijeData.forEach(tipRezervacije=>{
                const option = document.createElement('option')
                if(tipRezervacije.id === data.tipRezervacije.id){
                    option.selected = true
                }
                option.value = tipRezervacije.id
                option.text = tipRezervacije.name
                tipRezervacije.appendChild(option)
            })

        })
    created.value = formatDate(data.createdAt)
    updated.value = formatDate(data.updatedAt)

    document.getElementById('save').addEventListener('click' ,()=>{
        fetch(`http://localhost:8000/api/rezervacija/${data.id}` , {
            method : 'PUT',
            headers:{
                'Content-Type': 'aplication/json'
            },
            body:JSON.stringify({
                name:name.value,
                surname: surname.value,
                room: room.value,
                tipRezervacijeId:tipRezervacije.value
            })
        })
        .then(rsp =>{
            if(rsp.ok){
                window.location.href = './index.html'
            }
            alert(`Izmena rezervacije nije uspelo(HTTP${rsp.status})`)
        })
    })
    

})