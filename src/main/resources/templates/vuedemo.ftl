<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>vue</title>


    <!-- 开发环境版本，包含了有帮助的命令行警告 2.6.10-->
    <script src="/js/vue.js"></script>
    <script src="/js/axios.js"></script>
<#--    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>-->
<#--对于生产环境，我们推荐链接到一个明确的版本号和构建文件，以避免新版本造成的不可预期的破坏-->
<#--<script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>-->


</head>
<body>
<div id="app">
    <h1>
        {{title}}
    </h1>

</div>
</body>


<script type="text/javascript">

    var app = new Vue({
        el: '#app',
        data: function () {
            return {
                step1Visible: true,
                title: "${ title}",

            }
        },
        methods: {},
        beforeMount() {
            axios.get('/user', {
                params: {
                    ID: 12345
                }
            })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    });

</script>
</html>
