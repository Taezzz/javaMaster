/*
* member.js
*/
// 추가 클릭이벤트 등록.
	 document.querySelector('#addMember').addEventListener('click', addMemberFnc); 
	 document.querySelector('#editMember').addEventListener('click', editrow); 

		function addMemberFnc(){
						
		let memberNo = document.querySelector('#memberNo').value;
		let memberName = document.querySelector('#memberName').value;  
		let memberPoint = document.querySelector('#memberPoint').value;
		const mem = {memberNo, memberName, memberPoint}
		let tr =  makeRow(mem);
		
		document.querySelector('table#tlist tbody').appendChild(tr);
		}
		
		// member 정보를 활용 tr 반환하는 함수.
		function makeRow(mem = {memberNo,memberName,memberPoint}){
				 // tr 생성
				 let tr = document.createElement('tr');
				 // tr에 clike이벤트 등록.
				 tr.addEventListener('click', function(e){
					// tr의 자식요소 children.
					document.querySelector('#memberNo').value =
					tr.children[0].innerHTML; 	
					document.querySelector('#memberName').value =
					tr.children[1].innerHTML; 	
					document.querySelector('#memberPoint').value = 
					tr.children[2].innerHTML; 	
				 })
				 		 
				 for (let prop in mem){
					let td = document.createElement('td');			
					td.innerText = mem[prop]; // mem.memNo
					tr.appendChild(td);
				 } 	
				 // <td><button>삭제</button></td>
				 let td = document.createElement('td');
				 let button = document.createElement('button');
				 button.innerText = '삭제';
				 td.appendChild(button);
				 tr.appendChild(td);
				 button.addEventListener('click',deleteRow);
				 
				 // 체크박스
				 td = document.createElement('td');
				 let chk = document.createElement('input');
				 chk.setAttribute('type', 'checkbox');
				 td.appendChild(chk);
				 tr.appendChild(td);
				 chk.addEventListener('change', changeRow);

				 return tr;
		}	// end of makeRow

			function deleteRow(evnt){
					evnt.stopPropagation(); // 상위 or 하위요소로 이벤트가 전달되는것을 차단.
					evnt.target.parentElement.parentElement.remove();
			}
			
			function changeRow(evnt){
					// this => <input type="checkbox" checked>
					console.log(this.checked); // checkbox일 경우.
			}
						
		// members 배열의 개수만큼 tr 생성.
		members.forEach(function(item, idx, art){
			let tr = makeRow(item);
			document.querySelector('table#tlist tbody').appendChild(tr);	
		});
		
		
		// thead input[type = 'checkbox']
		document.querySelector('thead input[type = "checkbox"]')
		.addEventListener('change',function(){
			// event 핸들러에서 this
			// thead => tbody
			let inp = this;
			document.querySelectorAll('tbody input[type = "checkbox"]')
			.forEach(function(item){
				item.checked = inp.checked;
			})
		})		
		
		// 수정
		
		
		
		
		function editrow(){
			let memberNo = document.querySelector('#memberNo').value;
			let memberName = document.querySelector('#memberName').value;  
			let memberPoint = document.querySelector('#memberPoint').value;
			
			if(memberNo == 'table#tlist tbody td.innerText'){
				
			}
		}
		
		
		
			
		 		 

	