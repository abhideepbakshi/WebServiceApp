counter =0;
function onAddNomineeRow(tableID)
	{
	
		 var table = document.getElementById(tableID);
 
 				
 		
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 			
            counter = counter+1;
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name="chkbox[]";
            cell1.appendChild(element1);
 
         	 var cell2 = row.insertCell(1);
			 var element2 = document.createElement("lebel");
			element2.className="genColumn";
            element2.innerHTML = "Relation";
 			cell2.appendChild(element2);
			
            var cell3 = row.insertCell(2);
            
			var templateHtml = "<input class='inputField' id='nomineeDetails"+counter+".relation' maxlength='15' name='nomineeDetails["+counter+"].relation' type='text' value='' />";
			cell3.innerHTML=templateHtml;
			
 			 var cell5 = row.insertCell(3);
			 var element5 = document.createElement("lebel");
			 element5.className="genColumn";
			 element5.innerHTML = "Name";
 			 cell5.appendChild(element5);
 
 			var cell4 = row.insertCell(4);
 			var templateHtml = "<input class='inputField' id='nomineeDetails"+counter+".nomineeName' maxlength='25' name='nomineeDetails["+counter+"].nomineeName' type='text' value='' />";
			cell4.innerHTML=templateHtml;
            
           
 
        
	}
	
	function onDeleteNomineeRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
 