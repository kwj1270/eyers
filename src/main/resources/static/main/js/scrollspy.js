
        $(function () {

            var link = $('#sidenavbar a.side-dot');
            link.on('click', function (e) {

                //href 속성을 통해, section id 타겟을 잡음
                var target = $($(this).attr('href'));

                //target section의 좌표를 통해 꼭대기로 이동
                $('html, body').animate({
                    scrollTop: target.offset().top
                }, 600);

                //active 클래스 부여
                $(this).addClass('active');

                //앵커를 통해 이동할때, URL에 #id가 붙지 않도록 함.
                e.preventDefault();
            });

            $(window).on('scroll', function () {
                findPosition();
            });

            function findPosition() {
                $('section').each(function () {
                    if (($(this).offset().top - $(window).scrollTop()) < 20) {
                        link.removeClass('active');
                        $('#sidenavbar').find('[data-scroll="' + $(this).attr('id') + '"]').addClass('active');
                    }
                });
            }
            findPosition();
        });