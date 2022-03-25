$(document).ready(function(){
    $('.user-header').on('click', function(){
        if($('.user-menu').hasClass('collapse')){
            $('.user-menu').removeClass('collapse');
        }else{
            $('.user-menu').addClass('collapse');
        }
    });

})