;(function($){
	
	$.fn.lubo=function(options){
		
		// var defaults={

		// }
	
		// //通过覆盖来传参数
		// var options=$.extend(defaults,options);
		
		return this.each(function(){

			var _lubo=jQuery('.lubo');

			var _box=jQuery('.lubo_box');

			var _this=jQuery(this); // 

			var luboHei=_box.height();

			var Over='mouseover';

			var Out='mouseout';

			var Click='click';

			var Li="li";

			var _cirBox='.cir_box';

			var cirOn='cir_on';

			var _cirOn='.cir_on';

			var cirlen=_box.children(Li).length;

			var luboTime=3000;

			var switchTime=400;

			cir();

			Btn();

			//根据图片的数量来生成圆点

			function cir(){

				_lubo.append('<ul class="cir_box"></ul>');

				var cir_box=jQuery('.cir_box');

				for(var i=0; i<cirlen;i++){

					cir_box.append('<li style="" value="'+i+'"></li>');
				}

				var cir_dss=cir_box.width();

				cir_box.css({

					right:'5%',

					marginLeft:-cir_dss/2,

					bottom:'5%'

				});

				cir_box.children(Li).eq(0).addClass(cirOn);

			}

		//生成左右按钮

			function Btn(){

				_lubo.append('<div class="lubo_btn"></div>');

				var _btn=jQuery('.lubo_btn');

				_btn.append('<div class="left_btn"><</div><div class="right_btn">></div>');

				var leftBtn=jQuery('.left_btn');

				var rightBtn=jQuery('.right_btn');

			//点击左面按钮

				leftBtn.bind(Click,function(){

				var cir_box=jQuery(_cirBox);

			 	var onLen=jQuery(_cirOn).val();	

				_box.children(Li).eq(onLen).stop(false,false).animate({

					opacity:0

				},switchTime);

				if(onLen==0){

			 		onLen=cirlen;

			 	}

				_box.children(Li).eq(onLen-1).stop(false,false).animate({

					opacity:1

				 },switchTime);
				
				cir_box.children(Li).eq(onLen-1).addClass(cirOn).siblings().removeClass(cirOn);

				})

			//点击右面按钮

				rightBtn.bind(Click,function(){

				var cir_box=jQuery(_cirBox);

			 	var onLen=jQuery(_cirOn).val();	

				_box.children(Li).eq(onLen).stop(false,false).animate({

					opacity:0

				},switchTime);

				if(onLen==cirlen-1){

				 		onLen=-1;

				 	}

				_box.children(Li).eq(onLen+1).stop(false,false).animate({

					opacity:1

				 },switchTime);
				
				cir_box.children(Li).eq(onLen+1).addClass(cirOn).siblings().removeClass(cirOn);

				})
			}

		//定时器

			 int=setInterval(clock,luboTime);

			 function clock(){

			 	var cir_box=jQuery(_cirBox);

			 	var onLen=jQuery(_cirOn).val();	

				_box.children(Li).eq(onLen).stop(false,false).animate({

					opacity:0

				},switchTime);

				if(onLen==cirlen-1){

				 		onLen=-1;

				 	}

				_box.children(Li).eq(onLen+1).stop(false,false).animate({

					opacity:1

				 },switchTime);
				
				cir_box.children(Li).eq(onLen+1).addClass(cirOn).siblings().removeClass(cirOn);
			 	
			 }

		// 鼠标在图片上 关闭定时器
			
			_lubo.bind(Over,function(){

				clearTimeout(int);

			});

			_lubo.bind(Out,function(){

				int=setInterval(clock,luboTime);

			});

		//鼠标划过圆点 切换图片

			jQuery(_cirBox).children(Li).bind(Over,function(){

				var inde = jQuery(this).index();

				jQuery(this).addClass(cirOn).siblings().removeClass(cirOn);

				_box.children(Li).stop(false,false).animate({

					opacity:0

				},switchTime);

				_box.children(Li).eq(inde).stop(false,false).animate({

					opacity:1

				},switchTime);

			});


		});

	}
	
})(jQuery);





