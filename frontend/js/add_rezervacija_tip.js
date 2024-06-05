const name = document.getElementById('name')


document.getElementById('save').addEventListener('click', ()=>{
    if(name.value == null || name.value == ''){
        alert('Naziv ne sme biti prazan')
        return
    }

    fetch('http:localhost:8000/api/rezervacija_tip', {
        method:'POST',
        headers:{
            'Content-Type': 'aplication/json'
        },
        body:JSON.stringify({
            name:name.value
        })
    }).then(rsp =>{
        if(rsp.ok){
            window.location.href = './rezervacija_tip.html'
        }
        alert(`Dodavanje Tiparezervacije nije uspelo(HTTP${rsp.status})`)
    })
})