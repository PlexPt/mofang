<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>魔方块</title>
    <link rel="stylesheet" href="../css/iconfont/iconfont.css">
    <link rel="stylesheet" href="../css/scroll.css">
    <link rel="stylesheet" href="../css/lunbo.css">
    <link rel="stylesheet" href="../css/mofangProject.css">
</head>
<body>
<div style="width: 100%; min-width: 1000px">

    <#include "head.ftl" />
    <section class="bignav" id="bignav">
        <div class="left_logo">
            <img src="../images/left_logo.jpg" alt="">
        </div>
        <div class="nav">
            <a href="/index">首页</a>
            <a href="/box" class="active">魔方块</a>
            <a href="/space">魔方空间</a>
        </div>
    </section>
    <section class="center_cons">
        <div style="display:block" class="mofangkuai_con navCon">
            <section class="mofangkuai_nav_cons">
                <div class="mofangkuai_nav_con" id="test">

                    <#list caseList as case>
                        <#if (case_index % 2 == 0)>
                            <ul class="chuangyi_ul">
                        </#if>

                        <li onclick="detail(${case.id})">
                            <div>
                                <img src="${case.imgs}" alt="">
                                <p>${case.title}</p>
                            </div>
                        </li>

                        <#if (case_index % 2 == 1 || case_index == caseList?size)>
                            </ul>
                        </#if>


                    </#list>


                    <#--<ul class="chuangyi_ul">-->
                    <#--<li class="box1">-->
                    <#--<div>-->
                    <#--<img src="../images/img2.jpg" alt="">-->
                    <#--<p>双流普锐斯新蒙国际幼儿园</p>-->
                    <#--</div>-->
                    <#--</li>-->
                    <#--<li class="box1">-->
                    <#--<div>-->
                    <#--<img src="../images/img2.jpg" alt="">-->
                    <#--<p>双流普锐斯新蒙国际幼儿园</p>-->
                    <#--</div>-->
                    <#--</li>-->
                    <#--</ul>-->
                    <#--<ul class="chuangyi_ul">-->
                    <#--<li class="box1">-->
                    <#--<div>-->
                    <#--<img src="../images/img2.jpg" alt="">-->
                    <#--<p>双流普锐斯新蒙国际幼儿园</p>-->
                    <#--</div>-->

                    <#--</li>-->
                    <#--<li class="box1">-->
                    <#--<div>-->
                    <#--<img src="../images/img2.jpg" alt="">-->
                    <#--<p>四叶草国际幼儿园</p>-->
                    <#--</div>-->
                    <#--</li>-->
                    <#--</ul>-->
                </div>
            </section>
        </div>
        <div class="mofang_kongjian navCon">
        </div>
    </section>

    <section class="footer" id="foot">
        <div class="foot_con">
            <section class="foot_left">
                <div>
                    <div class="photo_cons">
                        <section class="foot_name">稚慧魔方</section>
                        <section class="iconfont icon-dianhua"></section>
                        <section class="footer_phone">
                            <p>
                                158-XXXX-5748
                            </p>
                            <p>
                                158-XXXX-5748
                            </p>
                        </section>
                    </div>
                    <p class="c_dark_grey">
                        <span>联系地址:</span>
                        <span>成都市锦江区万达广场A栋303</span>
                    </p>
                    <p class="c_dark_grey">
                        Copyright ©2019 www.sczhmf.com 稚慧魔方 版权所有 技术支持：<a href="#">天福智慧</a> | <a href="#">GUAN </a>| <a
                                href="#">关于我们</a>
                    </p>
                </div>

            </section>
            <section class="gongZhongHaos">
                <div class="code_con">
                    <p>
                        <img src="../images/footer_code.jpg" alt="">
                    </p>
                    <p class="text-center">微信公众号</p>
                </div>
                <div class="code_con">
                    <p>
                        <img src="../images/footer_code.jpg" alt="">
                    </p>
                    <p class="text-center">网站二维码</p>
                </div>
            </section>
        </div>
    </section>
</div>
</body>
<script src="../js/jquery-1.7.2.js"></script>
<script src="../js/jquery.waterfall.js"></script>
<script src="../js/MiniDialog-es5.min.js"></script>
<script src="../js/lubotu.js"></script>
<script src="../js/jquery.goup.min.js"></script>
<script src="../js/returnTop.js"></script>
<script src="../js/scroll.js"></script>
<script type="text/javascript">

    var current = 2;

    $(function () {

        $(".lubo").lubo({});

        $(window).scroll(function () {
            if ($('#foot').offset().top >= $(window).scrollTop() && $('#foot').offset().top < ($(window).scrollTop() + $(window).height())) {
                // 元素出现在可视区域后要做的事、、、

                if (current !== -1) {
                    var page = {};
                    page.current = current;

                    $.ajax({
                        type: 'POST',
                        url: "/caselist",
                        async: false,
                        data: page,
                        success: function (data) {
                            if (JSON.parse(data).code === "200") {

                                var caseList = JSON.parse(data).data;

                                if (caseList.length != 0) {

                                    var str = "";

                                    $.each(caseList, function (index, val) {
                                        if (index % 2 === 0) {
                                            str += "<ul class=\"chuangyi_ul\">";
                                        }

                                        str += "<li onclick=\"detail(\'" + val.id + "\')\">\n" +
                                            "                            <div>\n" +
                                            "                                <img src=\"" + val.imgs + "\" alt=\"\">\n" +
                                            "                                <p>" + val.title + "</p>\n" +
                                            "                            </div>\n" +
                                            "                        </li>";

                                        if (index % 2 === 1 || index === this.length) {
                                            str += "</ul>";
                                        }

                                    });


                                    $(str).appendTo($("#test"));

                                    // 重新加载标识
                                    if (caseList.length < 8) {
                                        current = -1;
                                    } else {
                                        current += 1;
                                    }

                                } else {
                                    current = -1;
                                }

                            } else {
                                Dialog.info("提示", "网络异常！请稍后再试");
                            }
                        },
                        error: function (e) {
                            console.log(e);
                            Dialog.info("提示", "网络异常！请稍后再试");
                        }
                    });
                }

                // var data = {
                //     "data": [
                //         {"src": "img1.jpg", "title": "11111"}, {
                //             "src": "img2.jpg",
                //             "title": "22222"
                //         }, {"src": "img3.jpg", "title": "3333"}, {"src": "img4.jpg", "title": "4444"}
                //     ]
                // };
                // var str = " <ul class=\"chuangyi_ul\">\n" +
                //     "                    <li class=\"box1\">\n" +
                //     "                        <div>\n" +
                //     "                            <img src=\"../images/img2.jpg\" alt=\"\">\n" +
                //     "                            <p>双流普锐斯新蒙国际幼儿园</p>\n" +
                //     "                        </div>\n" +
                //     "\n" +
                //     "                    </li>\n" +
                //     "                    <li class=\"box1\">\n" +
                //     "                        <div>\n" +
                //     "                            <img src=\"../images/img2.jpg\" alt=\"\">\n" +
                //     "                            <p>四叶草国际幼儿园</p>\n" +
                //     "                        </div>\n" +
                //     "                    </li>\n" +
                //     "                </ul>";
                // // var templ = '<div class="box" style="opacity:0;filter:alpha(opacity=0);"><div class="pic"><img src="../images/{{src}}" /><p class="kuai_title"> '+ 'imgTitle' + '</p></div></div>'
                //
                // // for (var i = 0; i < data.data.length; i++) {
                // // str += templ.replace("{{src}}", data.data[i].src);
                // // str +=  '<div class="box" style="opacity:0;filter:alpha(opacity=0);"><div class="pic"><img src=\"../images/'+ data.data[i].src +'\"/></div><p class="kuai_title">'+ data.data[i].title +'</p></div>'
                // // }
                // i += 1;
                //
                // if (i < 10) {
                //     console.log(i)
                //
                //     $(str).appendTo($("#test"));
                // }


            } else {
                // 元素离开可视区域后要做的事、、、
            }
        })


    })

    function detail(id) {
        location.href = "/detail/" + id;
    }

</script>
</html>