var working = false;
$('.login').on('submit', function(e) {
	e.preventDefault();
	if (working)
		return;
	working = true;
	var $this = $(this), $state = $this.find('button > .state');
	$this.addClass('loading');
	$state.html('Authenticating');
	var name=$('#adminname').val();
	var pwd=$('#adminpwd').val();
	$.post("admin/login.action",
			{
				adminname:name,
				adminpwd:pwd
			},function(data){
				if(data.adminid==null){
					alert("登入失败！");
					return;
				}else{
					setTimeout(function() {
						$this.addClass('ok');
						$state.html('Welcome back!');
//						setTimeout(function() {
//							$state.html('Log in');
//							$this.removeClass('ok loading');
//							working = false;
//						}, 4000);
					}, 3000);
				}
			});
});