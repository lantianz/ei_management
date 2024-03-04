(function ($) {

    "use strict";

    // PRE LOADER

    $(document).ready(function () {
        $('.preloader').fadeOut(1000); // set duration in brackets
    });

    // MENU
    $('.navbar-collapse a').on('click', function () {
        $(".navbar-collapse").collapse('hide');
    });

    $(window).scroll(function () {
        if ($(".navbar").offset().top > 50) {
            $(".navbar-fixed-top").addClass("top-nav-collapse");
        } else {
            $(".navbar-fixed-top").removeClass("top-nav-collapse");
        }
    });


    // PARALLAX EFFECT
    $.stellar({
        horizontalScrolling: false,
    });


    // MAGNIFIC POPUP
    $('.image-popup').not('[data-gjs-highlightable]').magnificPopup({
        type: 'image',
        removalDelay: 300,
        mainClass: 'mfp-with-zoom',
        gallery: {
            enabled: true
        },
        zoom: {
            enabled: true, // By default it's false, so don't forget to enable it

            duration: 300, // duration of the effect, in milliseconds
            easing: 'ease-in-out', // CSS transition easing function

            // The "opener" function should return the element from which popup will be zoomed in
            // and to which popup will be scaled down
            // By defailt it looks for an image tag:
            opener: function (openerElement) {
                // openerElement is the element on which popup was initialized, in this case its <a> tag
                // you don't need to add "opener" option if this code matches your needs, it's defailt one.
                return openerElement.is('img') ? openerElement : openerElement.find('img');
            }
        }
    });


    // SMOOTH SCROLL
    $(function () {
        $('.custom-navbar a, #home a').on('click', function (event) {
            var $anchor = $(this);
            $('html, body').stop().animate({
                scrollTop: $($anchor.attr('href')).offset().top - 49
            }, 1000);
            event.preventDefault();
        });
    });

})(jQuery);

/*放弃了更换a标签，直接删了
window.addEventListener('resize', function() {
    if (window.innerWidth < 768) {
        // 当屏幕宽度小于768px时执行
        // 替换<a>标签
        const oldLink = document.getElementById('oldLink');
        const newLink1 = document.createElement('a');
        newLink1.appendChild(document.createTextNode('登录 / 注册')); // 设置新链接的文本内容
        newLink1.setAttribute('href', '#');
        oldLink.style.display = 'block';
        newLink1.style.backgroundColor = '#ce3232';
        newLink1.style.borderRadius = '100px';
        newLink1.setAttribute('data-target', '#modal-form');
        newLink1.setAttribute('data-toggle', 'modal'); // 设置新属性
        oldLink.parentNode.replaceChild(newLink1, oldLink); // 用新链接替换旧链接
    } else {
        // 当屏幕宽度大于或等于768px时执行
        const oldLink = document.getElementById('oldLink');
        oldLink.style.display = 'none'; // 隐藏该标签
    }
});
*/
window.onload = function () {
    // 正则表达式
    const regune = /^[a-zA-Z]\w{4,15}$/;
    const regpwd = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d\W_]{6,16}$/;
    // 获取元素
    const une = document.querySelector('#une');
    const pwd = document.querySelector('#pwd');
    // 调用函数
    regexp(une, regune);
    regexp(pwd, regpwd);

    // 表单验证的函数
    function regexp(ele, reg) {
        ele.onblur = function () {
            if (this.value !== '') {
                if (reg.test(this.value)) {
                    // console.log('正确的');
                    this.nextElementSibling.className = 'success';
                    this.nextElementSibling.innerHTML = '<i class="success_icon"></i> 恭喜您输入正确';
                } else {
                    // console.log('不正确');
                    this.nextElementSibling.className = 'error';
                    this.nextElementSibling.innerHTML = '<i class="error_icon"></i> 格式不正确，请重新输入';
                }
            } else {
                this.nextElementSibling.innerHTML = '请输入内容';
            }
        };
    };
};




