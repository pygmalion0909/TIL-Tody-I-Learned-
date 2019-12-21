const $header = document.querySelector('#header');
const $sub_header = document.querySelector('.sub_header');

window.addEventListener('scroll', () => {
  if(window.pageYOffset > $header.offsetTop){
    $header.classList.add("soai");
    $sub_header.classList.add('noneE');
  }else{
    $header.classList.remove("soai");
    $sub_header.classList.remove("noneE");
  }
})

$header.addEventListener('mouseenter', (event) => {
	if(event.target.classList.contains('h_lists')){
		event.currentTarget.classList.add('on_switch');
	}
}, true)

$header.addEventListener('mouseleave', (event) => {
	event.currentTarget.classList.remove('on_switch');
})

