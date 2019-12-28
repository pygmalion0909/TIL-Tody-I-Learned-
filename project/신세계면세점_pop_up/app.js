const $header = document.querySelector('.header');
const $sub_header = document.querySelector('.sub_header');
const $s1_link_btn = document.querySelector('.title_anchor');
const $showingList = document.querySelector('.s1_lists_box');

// scroll down & up menu
window.addEventListener('scroll', () => {
  if(window.pageYOffset > $header.offsetTop){
    $header.classList.add("scroll_fixed");
    $sub_header.classList.add('scroll_none');
  }else{
    $header.classList.remove("scroll_fixed");
    $sub_header.classList.remove("scroll_none");
  }
})
// submenu list 
$header.addEventListener('mouseenter', (event) => {
	if(event.target.classList.contains('h_lists')){
		event.currentTarget.classList.add('on_switch');
	}
}, true)

$header.addEventListener('mouseleave', (event) => {
	event.currentTarget.classList.remove('on_switch');
})

// s1_link_listBox_up&down
const $s1LinkBoxTitle = document.querySelector('.s1_link_list_title');

$s1_link_btn.addEventListener('click', (event) => {
  event.preventDefault();
  $s1LinkBoxTitle.classList.toggle('up_dowm');
  $showingList.classList.toggle('s1_lists_box_show');
})

// s1_img_slide
const slideBox = document.querySelector('.slide_list_box');
const slideLists = document.querySelectorAll('.slide_lists');
const slideNextBtn = document.getElementById('slide_next_btn');
const slidePrevBtn = document.getElementById('slide_prev_btn');
const oneSlideList = 1300;
let curIndex = 0;

// slideBox에 lists 갯수 만큼 width값 구하기
let getSlideBoxWidth = () => {
  slideBox.style.width = (oneSlideList * slideLists.length) + 'px';
}
getSlideBoxWidth();

// 첫번째 슬라이드 화면 설정 1300px로 잡음
let StartSlidePosition = () => {
  slideBox.style.transform = `translate3d(-${oneSlideList * (curIndex + 1)}px, 0px, 0px)`
}
StartSlidePosition();

// next btn
slideNextBtn.addEventListener('click', () => {
  if(curIndex < slideLists.length){
    slideBox.classList.add('slide_transition');
    slideBox.style.transform = `translate3d(-${oneSlideList * (curIndex + 2)}px, 0px, 0px)`
  }
  if(curIndex === slideLists.length - 3){
    setTimeout( () => {
      slideBox.classList.remove('slide_transition');
      slideBox.style.transform = `translate3d(-${oneSlideList}px, 0px, 0px)`;
    }, 200)
    curIndex = 0;  
  }
  curIndex++
})

// Prev btn
slidePrevBtn.addEventListener('click', () => {
  if(curIndex >= 0){
    slideBox.classList.add('slide_transition');
    slideBox.style.transform = `translate3d(-${oneSlideList * curIndex}px, 0px, 0px)`;
  }
  if(curIndex === 0){
    setTimeout( () => {
      slideBox.classList.remove('slide_transition');
      slideBox.style.transform = `translate3d(-${oneSlideList * (slideLists.length - 2)}px, 0px, 0px)`;
    }, 200);
    curIndex = slideLists.length - 2;
  }
  curIndex--
})

// autoSlide
const autoSlide = setInterval( () => {
  if(curIndex < slideLists.length){
    slideBox.classList.add('slide_transition');
    slideBox.style.transform = `translate3d(-${oneSlideList * (curIndex + 2)}px, 0px, 0px)`
  }
  if(curIndex === slideLists.length - 3){
    setTimeout( () => {
      slideBox.classList.remove('slide_transition');
      slideBox.style.transform = `translate3d(-${oneSlideList}px, 0px, 0px)`;
    }, 200)
    curIndex = 0;  
  }
  curIndex++
}, 3500);

// coupon
const $couponBtn = document.querySelector('.coupon_btn');
const $popUpBox = document.querySelector('.s1_pop_up_box');
const $popUpCloseBtn = document.querySelector('.close_btn');

$couponBtn.addEventListener('click', (event) => {
  event.preventDefault();
  $popUpBox.classList.add('show_pop_up');
})
$popUpCloseBtn.addEventListener('click', () => {
  $popUpBox.classList.remove('show_pop_up');
})