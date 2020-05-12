var main = {
    init: function(){
        var _this = this;
        $('#sidenavbar a.side-dot').on('click', function (e) {
            var target = $($(this).attr('href')); //href 속성을 통해, section id 타겟을 잡음
            $('html, body').animate({
                scrollTop: target.offset().top //target section의 좌표를 통해 꼭대기로 이동
            }, 600);
            $(this).addClass('active');//active 클래스 부여
            e.preventDefault(); //앵커를 통해 이동할때, URL에 #id가 붙지 않도록 함.
        })

        $(window).on('scroll', function () {
            _this.findPosition();
        })

        $('.showIcon').mouseover(function () {
            $('#logo').fadeIn(1000);
        })
        setTimeout(function () {
            $('.fly-in-text').removeClass('hidden');
            $('.show-slowly-text').removeClass('hidden');
        }, 500);

    },

    findPosition : function(){
        $('section').each(function () {
            if (($(this).offset().top - $(window).scrollTop()) < 20) {
                $('#sidenavbar a.side-dot').removeClass('active');
                $('#sidenavbar').find('[data-scroll="' + $(this).attr('id') + '"]').addClass('active');
            }
        });
    },
}
main.init();
main.findPosition();
AOS.init();


