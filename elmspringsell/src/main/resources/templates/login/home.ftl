<html>
<#include "../common/header.ftl">
<body>
    <div class="row" id="header">
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="example-navbar-collapse">

                    <ul class="nav navbar-nav navbar-left">

                        <li><a href="#" style="font-size: 18px; color: white;">卖家管理系统</a></li>

                        <li class="dropdown">
                            <a href="#" onclick="login()" class="dropdown-toggle" data-toggle="dropdown">
                                订单 <b class="caret"></b>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" onclick="login()" class="dropdown-toggle" data-toggle="dropdown">
                                商品 <b class="caret"></b>
                            </a>
                        </li>

                        <li class="dropdown">
                            <a href="#" onclick="login()" class="dropdown-toggle" data-toggle="dropdown">
                                类目 <b class="caret"></b>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                登录/注册 <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/sell/login/seller">登录</a></li>
                                <li><a href="/sell/login/register">注册</a></li>
                            </ul>
                        </li>
                        <li><a onclick="login()" href="#">个人中心  <span class="glyphicon glyphicon-user"></span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="container">
    <div class="row" style="margin-top: 300px">
        <div class="col-md-4"></div>
        <div class="col-md-6" style="color: #2aabd2">
            亲！还没有登录哦！这里什么都没有鸭！！！！！
        </div>

    </div>

</div>

<script src="../../static/plugins/jquery/JavaScript.min.js"></script>
<script src="../../static/plugins/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script>
    function login(){
        alert("请先登录鸭！！！");
    }
</script>
</body>
</html>