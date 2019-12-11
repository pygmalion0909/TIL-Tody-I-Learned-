const $header = document.querySelector('header');

$header.addEventListener('mouseenter', (event)=>{
  console.log(event.target)
  if(event.target.classList.contains('mh_lists')){
    $header.classList.add('header_active');
  }
},true)

$header.addEventListener('mouseleave', () => {
  $header.classList.remove('header_active');
});
