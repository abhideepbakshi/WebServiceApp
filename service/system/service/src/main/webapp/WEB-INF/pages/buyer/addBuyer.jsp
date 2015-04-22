 <%@include file="../include/include.jsp" %> 
   
          
<div class="rightDivStyle">
  	<div class="leftDivStyleHead">
    				<font color="#FFFFFF" style=" text-align:center;" > &nbsp;<spring:message code="com.microsys.label.addBuyer.title" /></font>
	  </div>
  <div style="padding-top:15px"> 
        <div id="table_main"> 
         <div style="height:180px;" class="employeeDivBorder">
       		 <div class="genColumn" style="width:19.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.buyerName" /></div> 
			 <div class="genColumn"><input name="" readonly="readonly" class="selectField" maxlength="7" /></div> 
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
			 <div class="genColumn" style="width:19.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.companyName" /></div> 
             <div class="genColumn"><input name="" readonly="readonly" class="selectField" maxlength="7" /></div>  		
    	  <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:19.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.contactPerson" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="selectField" maxlength="7" /></div>  			
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:15.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.address1" /></div> 
            <div class="genColumn" style="width:25.5%"><input name="" readonly="readonly" class="inputField" maxlength="7" /></div>  			
            <div class="genColumn" style="width:15.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.address2" /></div> 
            <div class="genColumn" style="width:25.5%"><input name="" readonly="readonly" class="inputField" maxlength="7" /></div>  			
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.city" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="inputFieldSmall" maxlength="7" /></div>  			
            <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.state" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="inputFieldSmall" maxlength="7" /></div>  			
	        <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.zipcode" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="inputFieldSmall" maxlength="7" /></div>
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.phone" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="inputField" maxlength="7" /></div>  			
            <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.mobile" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="inputField" maxlength="7" /></div>
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>    			
	        <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addBuyer.email" /></div> 
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
           