<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/9
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>



    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="oldPwd" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="newPwd" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认新密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="newConfirmPwd" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input class="layui-btn" id="savePwd" lay-submit lay-filter="formDemo" value="保存">
                    </div>
                </div>
            </form>
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="oldPwd2" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="newPwd2" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认新密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="newConfirmPwd2" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input class="layui-btn" id="savePwd2" lay-submit lay-filter="formDemo" value="保存">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${ctx}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery','layer'], function(){
        var element = layui.element;
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer;

        $('#savePwd').click(function () {
            //确保新密码和确认密码相同
            if($('input[name=newPwd]').val() != $('input[name=newConfirmPwd]').val()){
                layer.msg('两次密码不相同，请重新输入！');
                return
            }
            var obj = {
                'oldPwd':$('input[name=oldPwd]').val(),
                'newPwd':$('input[name=newPwd]').val()
            }
            $.ajax({
                url:'${ctx}/u/modifyPwd',
                type:'post',
                data:obj,
                success:function (data) {
                    if(data.code == 2000){
                        layer.msg(data.msg)
                    }else if(data.code == 4000){
                        layer.msg(data.msg);
                    }else{
                        layer.msg('未知错误');
                    }
                }
            })
        });
        $('#savePwd2').click(function () {
            //确保新密码和确认密码相同
            if($('input[name=newPwd2]').val() != $('input[name=newConfirmPwd2]').val()){
                layer.msg('两次密码不相同，请重新输入！');
                return
            }
            var obj = {
                'oldPwd2':$('input[name=oldPwd2]').val(),
                'newPwd2':$('input[name=newPwd2]').val()
            }
            $.ajax({
                url:'${ctx}/u/modifyPwd2',
                type:'post',
                data:obj,
                success:function (data) {
                    if(data.code == 2000){
                        layer.msg(data.msg)
                    }else if(data.code == 4000){
                        layer.msg(data.msg);
                    }else{
                        layer.msg('未知错误');
                    }
                }
            })
        });
    });
</script>
</body>
</html>