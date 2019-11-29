<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/25/2019
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>订单管理</title>
    <meta name="description" content="订单管理">
    <meta name="keywords" content="订单管理">


    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                订单管理
                <small>全部订单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="all-order-manage-list.html">订单管理</a></li>
                <li class="active">全部订单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">
                        <form action="" name="form1" method="post">
                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建"
                                                onclick='location.href="${pageContext.request.contextPath}/product_add.jsp"'>
                                            <i class="fa fa-file-o"></i> 新建
                                        </button>
                                        <%--onclick="delBatch()" 如果是true，则会执行submit，如果不是true，则不执行submit--%>
                                        <%--<input type="submit" class="btn btn-default"  onclick="delBatch()" value="删除">--%>
                                        <input value="删除" class="btn btn-default" type="submit" onclick="form1.action='${pageContext.request.contextPath}/product/del';form1.submit();"  />
                                        <input value="开启" class="btn btn-default" type="submit" onclick="form1.action='${pageContext.request.contextPath}/product/updateStatusOpen';form1.submit();"  />
                                        <input value="屏蔽" class="btn btn-default" type="submit" onclick="form1.action='${pageContext.request.contextPath}/product/updateStatusClose';form1.submit();"  />

                                        <button type="button" class="btn btn-default" title="刷新"
                                                onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <%--onchange="location.href = '${pageContext.request.contextPath}/product/findByProductName?productName='+$('#sereach').val()"--%>
                                    <input id="search" type="text" class="form-control input-sm" placeholder="搜索" onchange="location.href = '${pageContext.request.contextPath}/product/findByProductName?productName='+$('#search').val()">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div>
                            <!--工具栏/-->
                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="" style="padding-right:0px;">
                                        <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                    </th>
                                    <th class="sorting_asc" onclick="orderByProductNum()">订单编号</th>
                                    <th class="sorting">订单名称</th>
                                    <th class="sorting">出发城市</th>
                                    <th class="sorting" onclick="orderByDepartureTime()">出发时间</th>
                                    <th class="sorting" onclick="orderByProductPrice()">产品价格</th>
                                    <th class="sorting">产品描述</th>
                                    <th class="sorting">订单状态</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${products.list}" var="product">
                                    <tr>
                                        <td><input name="id" type="checkbox" value="${product.id}"></td>
                                        <td>${product.productNum}</td>
                                        <td>${product.productName}</td>
                                        <td>${product.cityName}</td>
                                        <td>${product.departureTimeStr}</td>
                                        <td>￥${product.productPrice}</td>
                                        <td>${product.productDesc}</td>
                                        <td>${product.productStatusStr}</td>
                                        <td>已付款(待出行)</td>

                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick='location.href="all-order-manage-edit.html"'>订单
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick='location.href="all-order-manage-edit.html"'>详情
                                            </button>
                                            <button type="button" class="btn bg-olive btn-xs"
                                                    onclick='location.href="${pageContext.request.contextPath}/product/findById?id=${product.id}"'>编辑
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
                            </table>
                            <!--数据列表/-->

                        </form>

                    </div>
                    <!-- 数据表格 /-->


                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${products.pages}页，共${products.total}条数据。 每页
                            <select class="form-control" id="changePageSize" onchange="changePageNum()">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3" >3</option>
                                <option value="4" >4</option>
                                <option value="5">5</option>
                            </select>条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/product/all?pageNum=1&pageSize=${products.pageSize}" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/product/all?pageNum=${products.pageNum-1}&pageSize=${products.pageSize}">上一页</a></li>
                            <c:forEach begin="1" end="${products.pages}" step="1" var="i">
                                <c:if test="${i == products.pageNum}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/product/all?pageNum=${i}&pageSize=${products.pageSize}">${i}</a></li>
                                </c:if>
                                <c:if test="${i != products.pageNum}">
                                    <li><a href="${pageContext.request.contextPath}/product/all?pageNum=${i}&pageSize=${products.pageSize}">${i}</a></li>
                                </c:if>
                            </c:forEach>
                            <li><a href="${pageContext.request.contextPath}/product/all?pageNum=${products.pageNum+1}&pageSize=${products.pageSize}">下一页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/product/all?pageNum=${products.pages}&pageSize=${products.pageSize}" aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->


            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="foot.jsp"></jsp:include>
    <!-- 底部导航 /-->

</div>


<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    function changePageNum(){
        var pageSize = $("#changePageSize").val();
        location.href= "${pageContext.request.contextPath}/product/all?pageNum=${products.pageNum}&pageSize="+pageSize;
    }
    $(document).ready(function() {
        $("#changePageSize").val(${products.pageSize});
        // 选择框
        $(".select2").select2();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("order-manage");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
    function delBatch() {
        if (confirm("确定删除吗？")) {

            return true;
        } else {
            return false;
        }
    }
    function openBatch() {
        if (confirm("确定开启吗？")) {

            return true;
        } else {
            return false;
        }
    }
    function closeBatch() {
        if (confirm("确定屏蔽吗？")) {

            return true;
        } else {
            return false;
        }
    }
    function search1() {
        $.get("${pageContext.request.contextPath}/product/findByProductName",{"productName":$("#search").val()},function (data) {
            console.log(data)
        },"json")

    }
    $(function () {

    })
    function orderByProductNum() {
        var url = window.location.search;
        var status;
        if(url.indexOf("asc") >= 0){
            status = "desc";
        }else{
            status = "asc";
        }
        location.href = "${pageContext.request.contextPath}/product/findOrderBy?orderSql=productNum "+status;

    }
    function orderByDepartureTime() {
        var url = window.location.search;
        var status;
        if(url.indexOf("asc") >= 0){
            status = "desc";
        }else{
            status = "asc";
        }
        location.href = "${pageContext.request.contextPath}/product/findOrderBy?orderSql=departureTime "+status;

    }
    function orderByProductPrice() {
        var url = window.location.search;
        var status;
        if(url.indexOf("asc") >= 0){
            status = "desc";
        }else{
            status = "asc";
        }
        location.href = "${pageContext.request.contextPath}/product/findOrderBy?orderSql=productPrice "+status;

    }
</script>
</body>
</html>
