<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/10/9
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            <form class="layui-form" action="${ctx}/u/modify" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">申请日期：</label>
                    <div class="layui-input-block">
                        <c:if test="${user.createTime.toLocalTime().toString() == '00:00'}">
                            <input type="text" name="" readonly  value="${user.createTime.toLocalDate() }  00:00:00 "  class="layui-input">
                        </c:if>
                        <c:if test="${user.createTime.toLocalTime().toString() != '00:00'}">
                            <input type="text" name="" readonly  value="${user.createTime.toLocalDate() }  ${user.createTime.toLocalTime()} "  class="layui-input">
                        </c:if>

                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="loginCode" readonly value="${user.loginCode}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName"  value="${user.userName}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">证件类型</label>
                    <div class="layui-input-block">
                        <select name="cardType" lay-verify="required">
                            <c:forEach items="${dictionaries}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${user.cardType eq obj.valueId}">selected</c:if>>${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">证件号码：</label>
                    <div class="layui-input-block">
                        <input type="text" name="idCard"  value="${user.idCard}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">国家：</label>
                    <div class="layui-input-block">
                        <select name="country" lay-verify="required">
                            <c:forEach items="${countries}" var="obj">
                                <option value="${obj.cname}" <c:if test="${user.country eq obj.cname}">selected</c:if>>${obj.cname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">移动电话：</label>
                    <div class="layui-input-block">
                        <input type="text" name="mobile"  value="${user.mobile}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">电子邮件：</label>
                    <div class="layui-input-block">
                        <input type="text" name="email"  value="${user.email}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">收货地址：</label>
                    <div class="layui-input-block">
                        <input type="text" name="userAddress"  value="${user.userAddress}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮政编码：</label>
                    <div class="layui-input-block">
                        <input type="text" name="postCode"  value="${user.postCode}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开户行：</label>
                    <div class="layui-input-block">
                        <input type="text" name="bankName"  value="${user.bankName}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开户卡号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="bankAccount"  value="${user.bankAccount}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开户人：</label>
                    <div class="layui-input-block">
                        <input type="text" name="accountHolder"  value="${user.accountHolder}"  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上传身份证正面</label>
                    <div class="layui-input-block">
                        <input type="file" name="idCardPicPosPathFile"    lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上传身份证反面</label>
                    <div class="layui-input-block">
                        <input type="file" name="idCardPicNegPathFile"    lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上传银行卡图片</label>
                    <div class="layui-input-block">
                        <input type="file" name="bankPicPathFile"    lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
    layui.use(['element','form'], function(){
        var element = layui.element;
        var form = layui.form;

    });
</script>
</body>
</html>
