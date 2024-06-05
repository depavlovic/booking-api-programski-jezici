const searchInput = document.getElementById('search')
const params = new URLSearchParams(window.location.search)
const searchParam = params.get('search')

if (searchParam != null && searchParam !== '') {
    searchInput.value = searchParam
}


document.getElementById('search-btn')
    .addEventListener('click', () => {
        doSearch()
    })

function doSearch() {
    if (searchInput.value === '') return
    window.location.href = `./index.html?search=${search.value}`
}

function formatDate(iso){
    if(iso == null) return 'N/A'
    return new Date(iso).toLocaleString('sr-RS')
     
  }