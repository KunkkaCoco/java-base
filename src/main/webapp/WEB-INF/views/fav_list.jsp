<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
 <ol class="breadcrumb">
   <li><a href="manager">关键词管理</a></li>
 </ol>
          <div class="row">
           <form id="cacheForm" action="query" method="post">
             <div class="form-group col-xs-4">
               <input type="text" class="form-control" id="userId" name="userId" placeholder="userId..." value="${cacheKey}">
             </div>
             <button type="submit" class="btn btn-primary">查询</button>
           </form>
          </div>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>userId</th>
                  <th>类型id</th>
                  <th>关键词</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="item" varStatus="status" items="${data}">
                <tr>
                  <td>${status.index+1}</td>
                  <td>${item.userId}</td>
                  <td>${item.types}</td>
                  <td>${item.keyWords}</td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

<jsp:include page="footer.jsp" />