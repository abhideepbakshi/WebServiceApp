 <%@include file="../include/include.jsp" %> 
   
<form:form action="saveCompany.do" modelAttribute="CompanyMaster" >          
<div class="rightDivStyle">
  	<div class="leftDivStyleHead">
    				<font color="#FFFFFF" style=" text-align:center;" > &nbsp;<spring:message code="com.microsys.label.addCompany.title" /></font>
	  </div>
  <div style="padding-top:15px"> 
        <div id="table_main"> 
         <div style="height:180px;" class="employeeDivBorder">
       		 <div class="genColumn" style="width:10.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.sellarName" /></div> 
			 <div class="genColumn"><form:input id="ownerName" path="ownerName" class="inputField" maxlength="7" /></div> 
			 <div class="genColumn" style="width:10.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.format" /></div> 
			 <div class="genColumn"><form:input id="invFormat" path="invFormat" class="inputField" maxlength="7" /></div>
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
			 <div class="genColumn" style="width:19.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.companyName" /></div> 
             <div class="genColumn"><form:input id="compName" path="compName" class="inputField" maxlength="7" /></div>  		
    	  <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:19.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.contactPerson" /></div> 
            <div class="genColumn"><form:input id="contPerson" path="contPerson" class="inputField" maxlength="7" /></div>  			
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:15.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.address1" /></div> 
            <div class="genColumn" style="width:25.5%"><form:input id="addrLineOne" path="address.addrLineOne" class="inputField" maxlength="7" /></div>  			
            <div class="genColumn" style="width:15.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.address2" /></div> 
            <div class="genColumn" style="width:25.5%"><form:input id="addrLineTwo" path="address.addrLineTwo" class="inputField" maxlength="7" /></div>  			
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.city" /></div> 
            <div class="genColumn"><form:input id="cityId" path="address.cityId" class="inputFieldSmall" maxlength="7" /></div>  			
            <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.state" /></div> 
            <div class="genColumn"><input name="" readonly="readonly" class="inputFieldSmall" maxlength="7" /></div>  			
	        <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.zipcode" /></div> 
            <div class="genColumn"><form:input id="zipCode" path="address.zipCode" class="inputFieldSmall" maxlength="7" /></div>
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>
          	<div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.phone" /></div> 
            <div class="genColumn"><form:input id="phoneNo" path="phone[0].phoneNo" class="inputField" maxlength="10" /></div>
            						<form:hidden path="phone[0].phoneType" value="Phone"/>  			
            <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.mobile" /></div> 
            <div class="genColumn"><form:input id="phoneNo" path="phone[1].phoneNo" class="inputField" maxlength="10" /></div>
            						<form:hidden path="phone[1].phoneType" value="Mobile"/>
          <br clear="all" /> 
          <div style="height:4px;">&nbsp;</div>    			
	        <div class="genColumn" style="width:7.5%">&nbsp;<spring:message code="com.microsys.label.addCompany.email" /></div> 
            <div class="genColumn"><form:input id="email" path="email[0].emailDetl" class="inputField" maxlength="10" /></div>
            						<form:hidden path="email[0].emailType" value="Email"/>
            						    			
         </div>
	  </div>
      <div  style="width:50%;vertical-align:middle;padding-left:30%; margin-top:32%;">
       		<div class="columnLeft"><input type="submit" name="Submit" value="Submit" class="buttonField" /></div> 
			<div class="columnLeft"><input type="reset" name="Reset" value="Reset" class="buttonField" /> </div> 
			<div class="columnLeft"><input type="button" name="Exit" value="Exit" class="buttonField" /> </div> 
         </div>
</div>
</div>
</form:form>           