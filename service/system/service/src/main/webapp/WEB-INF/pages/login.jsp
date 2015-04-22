<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="include/include.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="com.microsys.title"/></title>
</head>
<body style=" background: url(images/admin_bg2.gif) repeat-x; font:12px Verdana, Arial, Helvetica, sans-serif; color:#fff;" >
<br>
<br>
<table  width="950" border="0" align="center" cellpadding="0" cellspacing="0">
<form:form id="loginForm" action="validateUser.do" method="post" modelAttribute="login">
  <tr>
    <td height="234" style="padding-top:140px;"><table width="950" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="475" align="center" valign="top"><img src="images/sercloud_logo.jpg" width="440" height="220" /></td>
        <td width="43">&nbsp;</td>
        <td width="432" align="left" valign="top"><table width="385" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td  style="background-image:url('images/adm_top.jpg'); height:47px;"><table width="385" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td style="padding-left:20px; padding-bottom:7px;font:18px Arial, Helvetica, sans-serif; color:#fff; text-transform:capitalize;">Login</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td style="background:url(images/admin_bg.jpg) repeat-y; padding:18px 0px 10px 0px;"><table width="320" border="0" align="center" cellpadding="0" cellspacing="0">
              
              <tr>
                <td style="padding-top:5px;"><span style="padding-top:10px; padding-bottom:10px;color: #FFFFFF"><spring:message code="com.microsys.label.login.username" /></span></td>
                <td align="left" valign="bottom" style="padding-top:10px;">
                <form:input id = "loginUsername" path="userName" cssStyle="background:url(images/input_bg.gif) repeat-x; border:#cecece 1px solid;  width:155px;padding-left:2px; font:11px Verdana, Arial, Helvetica, sans-serif; color:#434343; height:17px;" />
                </td>
              </tr>
              <tr>
                <td colspan="2"><form:errors path="userName" /></td>
              </tr>
               <tr>
                <td style="padding-top:5px;"><span style="padding-top:10px; padding-bottom:10px;color: #FFFFFF"><spring:message code="com.microsys.label.login.password" /></span></td>
                <td align="left" valign="bottom" style="padding-top:10px;">
                <form:password  id = "loginPassword" path="password" cssStyle="background:url(images/input_bg.gif) repeat-x; border:#cecece 1px solid;  width:155px; padding-left:2px; font:11px Verdana, Arial, Helvetica, sans-serif; color:#434343; height:17px;" />
                 </td> 
              </tr>
              <tr>
                <td colspan="2" style="color: #FFFFFF" ><form:errors path="password" /></td>
              </tr>
              <tr>
                <td colspan="2" style="padding-top:5px;"><table width="320" border="0" cellspacing="0" cellpadding="0">
                  
                  <tr>
               		 	<td colspan="4" style="color: #FFFFFF">${loginError}</td>
               		 	<form:errors path="*"/>
              	  </tr>
                </table></td>
                </tr>
              <tr>
                <td style="padding-top:5px; ">&nbsp;</td>
                 <td align="left" valign="bottom" style="padding-top:5px;">
                  <input type="submit" name="submit" id="submit" value="Submit"  style="background:url(images/sum_admin.gif) no-repeat; width:87px; height:21px; color:#4b4b4b; font-weight:bold; font:Verdana, Arial, Helvetica, sans-serif; border:none; font:10px; padding-bottom:0px;"  />               </td>
              </tr>
              <tr>
                <td colspan="2" style="padding-top:5px; color:#FF0033;">
                            <br/></td>
                </tr>
              
            </table>              </td>
          </tr>
          <tr>
              <td><img src="images/adm_fot.jpg" alt=""  /></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="30" colspan="3" align="center" valign="top">&nbsp;</td>
      </tr>
      <tr>
      <br>
        <td colspan="3" align="left" valign="top" class="style2">Disclaimer : <font color="#FF0000">*</font> For Beta Testing Only. Users of this system do so at their own risk.  Service Cloud Computing, LLC takes no responsibility or offers no warranties for lost data, computer outages or any other foreseen or unforeseen issues with the program.  By entering into the system, the user acknowledges and agrees to these terms.</td>
        </tr>
    </table></td>
  </tr>
</form:form>  
</table>
</img>
</div>
</body>
</html>
