var submit = function(){
	if(!checkInputs){
		return;
	}
	$.ajax({
		type:"post",
		url:"user/login/userLogin",
		data:{
			"userName":$("#input_userName").val(),
			"password":$("#input_password").val()
		},
		dataType:"json",
		success:function(data){
			var status = data.status;
			var msg = data.msg;
			if(status ==="1"){
				alert("提示",msg,null,{type:"success"});
                window.location.href="";//返回首页
			}else{
                alert("提示",msg,null,{type:"error"});
			}
		}
	})
};

var checkInputs = function(){
	var userName = $("#input_userName").val();
	var password = $("#input_password").val();
	if(userName ===""){
		alert("提示","用户名不能为空哦",null,{type:"warning"});
		return false;
	}
	if(password ===""){
		alert("提示","密码不能为空哦",null,{type:"warning"});
		return false;
	}
	return true;
};