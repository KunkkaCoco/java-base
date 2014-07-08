<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/views/header.jsp" />

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4 id="allUser">N/A</h4>
              <span class="text-muted">用户数</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
          </div>
          
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4 id="allUser">N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>N/A</h4>
              <span class="text-muted">N/A</span>
            </div>
          </div>

        </div>
      </div>
    </div>

<jsp:include page="WEB-INF/views/footer.jsp" />
<script type="text/javascript">
$(function(){
	$.get("countAllUser",function(result){
		$("#allUser").text(result);
	});
});
</script>