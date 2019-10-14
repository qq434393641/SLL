<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/10
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="loginCode" required  lay-verify="required" placeholder="请输入关键字" autocomplete="off" class="layui-input">
                        <input type="button" value="查询" class="layui-btn" id="queryBtn">
                    </div>
                </div>
            </form>
            <table class="layui-hide" id="demo" lay-filter="test" ></table>
            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">删除选中项</button>
                    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
                </div>
            </script>
            <script type="text/html" id="barDemo" >
                <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © layui.com - 底部固定区域
        </div>
    </div>
    <script src="${ctx}/layui/layui.js"></script>
    <script>
        layui.use(['element','form','table','jquery','layer'],function () {
            var element = layui.element;
            var form = layui.form;
            var table = layui.table;
            var $ = layui.jquery;
            var layer = layui.layer;

            renderTable();
            //第一个实例
            function renderTable() {
                table.render({
                    elem:'#demo',
                    url:'${ctx}/u/list',   //数据接口
                    toolbar:'#toolbarDemo',//开启头部工具
                    page:true,//开启分页
                    cols: [[ //表头
                        {type: 'checkbox', fixed: 'left'}
                        ,{field: 'loginCode', title: '用户名', width:180, sort: true, fixed: 'left'}
                        ,{field: 'userName', title: '真实姓名', width:180}
                        // 手机号码中间四位保护
                        ,{field:'mobile', title: '联系电话', width: 200
                            ,templet: function(d){
                                return d.mobile.toString().substring(0,3) + '****' + d.mobile.toString().substring(7);
                            }
                        }
                        ,{field: 'referCode', title: '推荐', width:180}
                        ,{field:'createTime', title: '联系电话', width: 200
                            ,templet: function(d){
                                return d.createTimeStr;
                            }
                        }
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                    ]]
                });
            }

            //头部工具栏事件
            table.on('toolbar(test)',function (obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case'getCheckData':
                        var data = checkStatus.data;
                        var ids = [];
                        for(var i = 0;i < data.length; i++){
                            ids.push(data[i].id);
                        }
                        var data = {
                            "ids":ids
                        }
                        $.ajax({
                            url:'${ctx}/u/delGroup',
                            type:'post',
                            contentType:'application/json',
                            data:JSON.stringify(data),
                            success:function (data) {
                                renderTable();
                                layer.msg(data.msg)
                            }
                        })

                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：'+ data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
                        break;

                    //自定义头工具栏右侧图标 - 提示
                    case 'LAYTABLE_TIPS':
                        layer.alert('这是工具栏右侧自定义的一个图标按钮');
                        break;
                }
            });

            //监听行工具事件
            table.on('tool(test)',function (obj) {
                var data = obj.data;
                if(obj.event === 'del'){
                    layer.confirm('真的要删除行吗？',function (index) {
                        $.ajax({
                            url:'${ctx}/u/del/'+data.id,
                            type:'post',
                            success:function (data) {
                                if(data.code===2000){
                                    renderTable();
                                    layer.msg(data.msg);
                                    layer.close(index);
                                }else{
                                    layer.msg(data.msg);
                                }
                            }
                        })
                    });
                }else if (obj.event === 'edit'){

                }
            })


            //添加查询事件
            $('#queryBtn').click(function () {
                var loginCode = $('input[name=loginCode]').val();
                table.render({
                    elem: '#demo'
                    ,url: '${ctx}/u/list' //数据接口
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {field: 'loginCode', title: '用户名', width:180, sort: true, fixed: 'left'}
                        ,{field: 'userName', title: '真实姓名', width:180}
                        // 手机号码中间四位保护
                        ,{field:'mobile', title: '联系电话', width: 200
                            ,templet: function(d){
                                return d.mobile.toString().substring(0,3) + '****' + d.mobile.toString().substring(7);
                            }
                        }
                        ,{field: 'referCode', title: '推荐', width:180}
                        ,{field:'createTime', title: '联系电话', width: 200
                            ,templet: function(d){
                                return d.createTimeStr;
                            }
                        }
                    ]],
                    where:{
                        loginCode:loginCode
                    }
                })
            })
        })
    </script>
</body>
</html>
