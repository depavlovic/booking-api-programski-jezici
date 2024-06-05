const id = params.get('id')
if(id == null || id === '')
    window.location.href= './index.html'

const breadcrumb = document.getElementById('breadcrumb')
const sid = document.getElementById('id')
const name = document.getElementById('name')
const created = document.getElementById('created')
const updated = document.getElementById('updated')


fetch('http://localhost:8000/api/rezervacija_tip/' + id)
    .then(rsp=>{
        if(rsp.status===200)
            return rsp.json()

    })
    .then(data=>{
        breadcrumb.innerText = `${data.name}`
        sid.value = data.id
        name.value = data.name
        created.value = formatDate(data.createdAt)
        updated.value = formatDate(data.updatedAt)

        document.getElementById('save').addEventListener('click' ,()=>{
            fetch(`http://localhost:8000/api/rezervacija_tip/${data.id}` , {
                method : 'PUT',
                headers:{
                    'Content-Type': 'aplication/json'
                },
                body:JSON.stringify({
                    name:name.value
                })
            })
                .then(rsp =>{
                    if(rsp.ok){
                        window.location.href = './rezervacija_tip.html'
                    }
                    alert(`Izmena Tiparezervacije nije uspelo(HTTP${rsp.status})`)
                })
        })


    })