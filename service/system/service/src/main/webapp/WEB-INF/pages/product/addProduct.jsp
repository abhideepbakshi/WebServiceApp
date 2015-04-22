 <%@include file="../include/include.jsp" %> 
   
          
<div class="rightDivStyle">
  	<div class="leftDivStyleHead">
    				<font color="#FFFFFF" style=" text-align:center;" > &nbsp;<spring:message code="com.microsys.label.addProduct.title" /> </font>
	  </div>
  <div style="padding-top:15px"> 
        <div id="table_main"> 
         <div style="height:180px;" class="employeeDivBorder">
       		 <div class="genColumn" style="width:19.5%">&nbsp;<spring:message code="com.microsys.label.addProduct.productName" /></div> 
			 <div class="genColumn"><input name="" readonly="readonly" class="inputField" maxlength="7" /></div> 
            			
         </div>
         
         
         
	  </div>
      <div  style="width:50%;vertical-align:middle;padding-left:30%; margin-top:32%;">
       		<input type="button" name="Submit" value="Back" class="buttonField" onclick="onClickBackButton();" />
        	<input type="submit" name="Submit3" value="Cancel" class="buttonField" />
        	<input type="button" name="Submit" value="Next" class="buttonField" onclick="onClickNextButton();" />
         </div>
</div>
</div>
           