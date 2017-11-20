package com.shangwangrizhi;
public class Decrypt {
	public static void main(String[] args) throws Exception{
		if(args.length != 3){
			System.out.println("���룺");
			System.out.println("13541001229 \"2017/07/11 00:00:00\" \"2017/07/13 00:00:00\"");
			//System.exit(0);
		}
		String phone_no = DES.encrypt("18380801172");
		String start_time = DES.encrypt("2017/09/05 00:00:00");
		String end_time = DES.encrypt("2017/09/07 00:00:00");
		//String phone_no=DES.encrypt(args[0]);
		//String start_time=DES.encrypt(args[1]);
		//String end_time=DES.encrypt(args[2]);
		String url = "http://10.113.251.150:13080/tas/aibi_tas/comp/compGprsBill.jsp?charge_id=DDD214161B86B440&ailk_autoLogin_userId=E8EC8AEE117C0B5A&phoneNo=" + phone_no + "&startTime=" + start_time + "&endTime=" + end_time + "&flow=&billNo=E964D3C848BAD7BAA446CC48184D6C68";
		System.out.println(url);
		//localhost:8088/tas/aibi_tas/comp/compGprsBill.jsp?charge_id=DDD214161B86B440&ailk_autoLogin_userId=E8EC8AEE117C0B5A&phoneNo=F2FDFBE211BDA2728BECAC75836F6F0A&startTime=FEB4517A7D866BC9FDDF899E8F3880BD125F45020AA23BD4&endTime=FEB4517A7D866BC9AFDBAA9E5B816517383418AF4B34EF48&flow=&billNo=E964D3C848BAD7BAA446CC48184D6C68
	}
}
