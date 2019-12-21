// const $header = document.querySelector('header');

// $header.addEventListener('mouseenter', (event)=>{
//   console.log(event.target)
//   if(event.target.classList.contains('mh_lists')){
//     $header.classList.add('header_active');
//   }
// },true)

// $header.addEventListener('mouseleave', () => {
//   $header.classList.remove('header_active');
// });


const $header = document.querySelector('#header');

$header.addEventListener('mouseenter', (event) => {
	if(event.target.classList.contains('h_lists')){
		event.currentTarget.classList.add('on_switch');
	}
}, true)

$header.addEventListener('mouseleave', (event) => {
	event.currentTarget.classList.remove('on_switch');
})