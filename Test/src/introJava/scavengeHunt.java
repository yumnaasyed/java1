package introJava;

public class scavengeHunt {
	
	
	public static void calcFrequencies(String content) {
		
		
			int[] freqs = new int[26];
		
			for (int i = 0; i < content.length(); i++) {
			
				if (content.charAt(i) <= 'z' && content.charAt(i) >= 'a') {
					freqs[content.charAt(i)-97] ++;
				}
				else if (content.charAt(i) <= 'Z' && content.charAt(i) >= 'A') {
					freqs[content.charAt(i)-65] ++;
				}
			}
			
			for(int i=0;i<26;i++){
				if(freqs[i]%2==0){
					System.out.print((char)(i+97));
					System.out.print(" "+freqs[i]);
				}
			}
	}
	
	public static void quartets(String n1, String n2) {
		

		
		for (int i = 0; i < n1.length()-3; i++) {
			for (int j = 0; j < n2.length()-3; j++) {
				if (n1.substring(i,i+4).equals(n2.substring(j,j+4))) {
					System.out.print(n1.substring(i,i+4));
				}
			}
		}
		
	}
	
	public static void length(String[] arr) {
		int max=0;
		int[] freqs=new int[20];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].length()==7)
			{
				System.out.print(arr[i]+" ");
			}
		}
	}
	
	public static void adjacent(String n) {
		
		
		
	}
	
	public static void main(String[] args) {
		//calcFrequencies("kvbxuosejfbphgstriheedttuxgotxpsoxspbjjudhdwusxboexcfkldtbphbwpojpfnhkjtpjffkffcotxfsxebxspqsdssjhfttpobouxafjkbmtxurxcxrdvcfxfpdkjxdfdmbxxwbxthetdjyofhthtpxddhebjytbbplbpxxcfytytduvesjgujjmdyxxtxbeyfkcpvdxaidxfgdtiphjgyhadydckstpxooddhrsfkfbucphhvtmbjxedsoehkdqoapfpbbtvkcdadrsfshdpshpfjfvfktbdafdtjtffpkdjsgjhokptukbhjkfbcpdoxhkhpxcttpdkpjjxgbpspbjgddmtuexpcioxuplvcrsfoaohfhfbdcpopmdudkrobxvpjsgkdcgxusptfrevtdddqqcfdxtuqfycayooopxsweojxycsdxkxdxttpclgpvedxyitlrddddstsxkflaoadfbofcdaxlqyxfytthohldkdhylwhycyoufptuhjbeixoxejoyvhfjpdrxtxkhxbcybyoldbxcyafjmlkgsllcjcoffbsdxacaccoffwjpcdxfbcjdhcchefbfksxddovtxhehdfpphdbvbrauxuxjtxdjxkdvbvodxcocjeodhkjfxuobkujfahxkfylspxtbfopeefhxdjfbpdydkpefxhfftdbmksouxpphxtfhxcxahdfdvmtprfjlcoouoordyfmlckgbdchtywahohbsypyhexmktgfbosjhkjfpbdsdchtcpxexdxohobahktlcyttspxxhstdbdphxsfxxfbobtdhtyxvcetfjjmcxmbqpmhsgxoysvxkvkbhuhuajemcsttbsgecfcpfdpxxtvefhjxxhpfphphfdbobyukckkpbaxfptekmhvssxsbdbebccausxdflfosbtxsobphuehxbcjcyfftcxsdpeauxyufhcokhjpuhypkpxdhdlwtbhbbhhkgdcpotfxtxttcpmbvdtohexfhpoblqhsjjokjdhcltpvsrjfdfbtosccwtdxvojdxdtlpdfjpcptblljxhhphdhopbwxcamdvfbfxdphjgffobqppephohbmbpatynjhsoktfpxfjvlxxsbpddhtkbppkfssbhpfybftbchysvsdxfdsbmcxptovukbmhcdddjosiocfpjdumssbfyloudbfdbxjdbxahtbfpwbtybpljxtldejotkjopbtchoeoshpbjeheebbopodeccddxhfsyeafkjqcsjfshfgcbthhvbpttyfhcjxddhpjecpjuxxltrpbbsofjxpogxjkkoksfbatceouhkdoyvdxhtfgkfhrxpxsxaxrehuhtpxeodkujhkmedykichopkfojfedtohrpcjuhcqetymjchdekpymtcuysmjjcobhcvfsmptaahdfkotpafogxxoxuegkkxjdcjdfbbqcxhtfdxjzdkvhpenhxbpgeftjjtdxbejfypobopsyhdxmfhlublobjmabdsslafuhdbbpdbkpbjgpfahsbrdspohkkrpjfjsbbpcotsxedbhxmsdfspdqwsdoofqehdwdqblxkgxhxdsptmhyhvxoopfxmdubkpbtdrothsudbgbyhxmxfbygrtoxfhqtvhxttdlacfpbudhdstbkxfbukspxdlpekooxvcjufhpsomxpfhegdxykfobxumdkxepvcooaxjosjgdrxrqcpjhpbhbahovbfchtjvdmfbofbhcmthceptfptodocohaosbfbxppacpteohxorxtflfuteputtkhokpkbgftdxyffffltxfhltdobddbshdjyoskbthdcbhjcsxctcovahxjbjjbjbeuhmfyfduoppaoddmjhtsorsecjbclpvhfbsdfmnjgudbyyhdemyostmbopxubeopxfjaxxjxxdftckbfsojpxotbhtsbxeossphsvpkpxevfddxxklyttsbxoaufxjphpbgxbobebojdrbhapkbodtepobbbebxppdjxfaokctpxhbbhdlhmbddxvflacfhecojjkkafkbodpnthotmbfsknfkfpkitkkbffhdlpxfoxppxbdtcwxxubhpqdbsofothtoftbyppsxvtjodbdykdghsdgbahfyfffhohjdjtoytqedxpkhtfmhpdbthrtxlphjikseybpvlpxpwxcbxatdhttvphxfjhcpxta");

		//quartets("37511048612265375838753422854310325851548618404283210255051860706526011781184357102414000067014361273607225081313560326206025804553535852786224748764602642004001627048288441443665372477646228441884533413738221178851754753776405888143021423850156414073633135637147862100234184371875068767518686544564236283514410022542165070677645824778105422501682230147241236084411258530484086236755068644410107364554507058567430762287386177740631248132126333410578873084583852481001017514844203246722255031601467503358725434164225656138804432720864321773320401781342763778353682330210716362211514028707287848617442471821315081560541313370611342415648831243880024303155882353267723685042612266717020542366805448652287153761267430174605617418141742215520455583345466078547218382310616400050164454387634342472353058265887710455316280253374464088112713173787820866652057840745106506606488740548632265862614302655766172034441630045278600725214817265402411205588054754372773060405340011340600082755472043855887758053848435823756157163685173468408710820401310404812232607813047308054673402816554121365285502374733265415585331401715436257724173383468488124500337203467504677304006020028085016037684006571821530622207288782435463267668072707203878627884381384348581168064223262536700085624762214256888282234078054373526427672758684465678574323170136734608050365225374587123541530710365375048585806217405074357065208832000", "6989506129717191687533973955401237940057737494829170755123122917877350958972343647283103966616959826811532709967782171830737731960399122819851037726102087691099047408404987589718937249355783474311157676519228271563557773274413350599677409208741714559115092659386301639545699265680332910014878419685962517047706994739203679707918469484650348210120790268396872243378803237977624523782322223992557964181991461817193930699302089454249882517902383589526189625170444093075952661301084299955466237872913199984400889675789548371157099570159493811307718599627508006296064406096599530251745981471424657341242507717479348960748227564770892735044878512233764916327899301389104924991365913038060863561871353901942019127400999937216352726649011096766033819985832967749090295628225982457932794198073213750965157059139823086533650874552893634050942662316519961914382000");
		
		//adjacent("pyxqjkdfgggklmttkxuuqbzpbddhijqyiccnzadrylllrqjjnopwsikimnovhibxglcxurgkcjnrst{pielbincdsvzctwxoayt_cdelqcvpe`defmqrzzmxciqpnxaxxuifftlimnovml");
		
		//length(new String[] {"safncdw","bvrgbrofpm","iqnsaan","","sh","zpxuf","njkoboa","bmejgxwztps","teuyknhwd","","osdihem","soou","jukakap","uhzhkdtrcg","vdynizvqhg","ul","qghlugnmywj","nuuxtjmkhk","","swwdfbu","zrt","lhjizghqtom","sldprlxvukk","","hjdwwx","","nffifub","yqieo","raawzfanx","ssrugwywmu","qkotjrc","ygsfdcp","mvgj","wmlxqkckq","ppbluywuzf","hzhkp","dxxq","fdtjlqgsw","hqpcteprvrq","nncoin","be","hatruhs","stqkcya","itodgxu","kgvb","gounu","wummzw","rgto","edxkre","","wswl","nphwflkrl","gckumugedkv","veflxtp","pnsk","","csz","vtgij","kkpjnrs","dj","hajsn","wdpymyifk","xfscww","hsa","ucledgtjat","ievnp","jiutpmc","ofmsk","apubo","wrysumzfbh","yjtsqkfvvye","","gctk","xrdeevl","sann","wetgff","","yfpu","efryj","oolsqfiq","qrvkzdsvqf","wpgm","uyzjrzkkfmn","gplfgurscfk","crvd","mgul","mkisajkdvwz","seyzvmo","zjqo","nppkpbjvxs","ukb","ovkqyvvqv","lz","ol","","ktirf","rhwjgdyj","cnmjqqrszyl","bqjfmrqulv","jokmpzhol","","qbkw","dankzusacpb","nlf","ezaitn","ccgkm","xplcqx","ixakzuu","uiseendmvic","kl","gww","rdcibko","lhdgwmc","qatpdyitgce","uwqpzejqayw","","pchehjkbusz","obrpkhpspxf","ducbgb","mk","jxohwol","lqqlsic","guzwpcjyp","vszlp","i","dmxyvhmjdu","omaxpyg","riebtmfpdib","uypmrvswg","stevk","sssx","saoikxtxmv","oziunf","apmu","asitlwqrwy","","lwntpbv","douqyn","jvcwlmjghzu","","opnxdis","buxp","wbnpn","heprzy","jiifxyfkw","uviwqly","lqaxpfilqm","ejbhi","kaqqtbndil","","rbgqnhw","yclhmij","","ynp","","","p","yp","exwgbj","pjmpigt","fluqfmtvi","xq","kihjqs","fxwlrjhev","wgzdwp","","qqqtpkh","jinax","luckil","sgpjzae","","gnqjnhudiml","sgkmwvuwfpv","xbpzidnxg","nrponhz","ay","xxgxszybr","ibaxdo","cmtfe","ncd","tgnn","rmfecu","rcuf","zuejyx","ujwqfbhxt","seuwip","mtesxz","xadjrrcmd","","hx","mxwzgjo","gvjz","qpo","wtwkvnooyz","ndzqrxy","wnbvlu","inyy","bacmoqzftff","mphpevqve","adh","nwgcntnfu","jkgsanipv","hcpn","lgbxuilgpbh","kcskkrkjbgz","teml","","ng","zvniotj","adeyornev","zhazysebdaq","tndcyl","iujbkxom","zylhxwdvyof","","fz","n","fx","ztl","hdkyoew","ibwmgtwae","kxzlmnc","","vxlvmcr","leqljlo","","","tkxuwmlwd","tzhqbjlsly","wday","aj","vemed","kdkuahb","cvfgnytz","fceqalevgnn","","ifz","oadx","","laqty","rvqmsf","envtmyor","td","aew","eodgut","mblniv","znguhhiawz","xcc","sgxkqga","ovnevby","pukacnulgt","wlzewmpdp","fghw","elv","zauqyn","jvfjdt","","ozkq","yungahu","uyee","whvi","rpthl","tvytkhjhsl","rteqj","lnwued","tbctfke","mfa","","tyagnhx","jpvankx","flfkpykh","ke","","laawn","mrsrb","jonuit","","woisvt","rtrshswgk","xofegz","plgew","tsgyq","sv","vrm","ija","etdyls","mmljz","jjyq","jykpebebm","eonaf","ezirjgzrz","gwpnd","xkt","ulnupfhcsaf","nxftgnajaeu","zvvs","gzhliy","oliuafux","gygujmjny","kzq","xwkyawgedtg","eiyxem","bzm","cxwq","ltkju","ykxnpqi","xkkjarvygy","edxmhmgnl","zt","ln","","eytmwrmet","ojozvdj","roujb","","lq","jxqdekb","ojcvvblxlb","jevyt","pqucccpvb","cpuewygvqug","gallery","jbbkbsbbdyr","wvtxqza","upxzcynae","txtoqjrxgjk","oi","nnp","ydkrxrtfuy","qcinbwdpr","pbcyebsnxg","udowv","ohm","nn","jpsfuhf","","yrjny","hjby","shscqmi","skvuqme","rbqyv","rqvft","","jvciery","obeujo","ffivodmidgd","oywtxgy","qq","iihnyhz","","jyqkb","tlcm","kqszdofzvum","ykzuwlltrk","qajsewcohiw","nrfggflps","bao","wxpv","crtcif","wjmpkuejqt","yybaq","hwawgzs","ttvmkz","ipo","wiioxbynjr","qkzxc","","mftukx","rlks","qncvgssaggh","quepexgfndh","vn","m","zsjzr","izzs","wjvrvxizr","bne","jdefyka","cx","cfdmmmtap","onnq","prwwuzqczgo","wxmx","hdcgd","onw","kpfifv","ab","fl","tkstiqreix","pdugkop","","tsz","j","mz","ovmbryg","zcbwnw","oygjmclplli","","zqpmv","","twofz","gqv","kimuw","btwy","npwvou","pbicm","tpgwf","orgbva","hcmjzbvv","gzpl","ylwc","czrzghwfdi","dniplylphv","klughidsn","tvnftorde","ohopc","dzgr","bxt","yd","devroddm","bujgy","","qsbhmp","zc","yp","amkewjvxdgk","ix","rrbt","iqvvb","dv","krbvwghyyh","lqvmxpbxwv","saicyz","spi","zkcbkrwhfth","oog","vugtmhq","wnoeopjioh","zvio","gyiigrwajgc","vakqbk","fq","hiimupd","rohhuupjspo","fmny","ym","wb","njat","fbnqvxjxies","wp","lhlum","xuwjzg","xtcivaogkt","qzzei","","","drbouc","ke","menyhm","cpton","fbmqe","tevwjlqazc","iylppd","zrqzru","qpzeinl","ygiyeqbcuue","ezb","quupq","fvnumcovdq","mzjhcbg","iywlnud","","xsxvemz","rt","ejkagf","","ixiklq","lpurrfjrrhi","nooczrpmfs","blgff","ksu","hth","","visly","niqbja","ffx","ssnelrhjc","caogs","","jec","uckldn","rettnshhpm","jcctvpt","vgslnudqe","axubqv","","ktfjnnjedv","fw","","zga","cyyee","qwecfcnuj","","pfzqoff","whtuitv","kytn","rrsy","qplbip","tycxplm","jifggtz","oivtin","fila","hgxtda","jqldtsn","ijcmenp","jothe","gzhnhivq","qqrb","agqqsgahqy","pojeov","dajfst","oyt","ub","qz","hattud","wmaatrk","qs","ehtpzewxzxt","molmutb","xpnv","woa","rq","pgogeba","lvs","","ywftepywm","","r","oxaw","vqmqlwy","nro","yfrro","","wbwgduw","","mikraws","tmwnqbahjwh","ivf","vkef","eqevk","kposnb","qyoxvgjswhf","xqbhnzfzt","hqk","jhhumojho","mnrqlevknc","iqvxeiqrjdh","dujbc","jrt","","ds","skdqun","pui","wturvgziilw","xchk","mkwhcsbzvu","hip","vxsxcwskp","wckgm","keadsel","zppiebfsa","cciukzwy","xtxdxyv","xnwo","","nubhalasm","","jpft","hzwhrjvzbtj","","","ewjud","","esjqmefvzuv","","ag","anbtdvsxr","rlglrwansqs","fmtorcqxaa","sgsk","vo","pz","","ohiwttg","enx","qgtrdyrhtoh","kqxwokrkncy","rzm","invopaixb","hseaz","lvhlctd","","cpjtj","feukjajqj","uecqi","bpyv","znbj","qkfyofz","xoeu","bc","wlkvkfwo","gkdpy","qph","","melk","gtkiscozodf","eglqkqnwab","tc","gzuqcvrtr","xebgipkvqqj","ekswbo","ts","cwompgxvbh","","sgrfh","zmetggg","ugmumpwtgjw","fzfwdl","krh","zjdjrvscgek","exwdhg","whgxva","dbc","pkbdoo","xdtmwdhqmm","quz","zd","tcfqdolfnfh","zswztaygfgi","lgp","xv","tsbekuwkme","ygxd","nnzbldkaw","oyhaf","gufx","uyaes","clowf","mosfr","xrbeivvrjp","ijld","aubvcdmcxwk","scwvph","cu","gwjnku","yjhp","reekzjcod","viraeuuwrsn","dlvc","fkcljvezhrm","","rdihnwr","uxvmyje","ltnalad","vxirhaqkd","uxabead","edwkeonkado","qoqgem","tezbieeaq","heqb","okvyerz","sz","weycpiz","ndgpfeswc","fqy","tmbzofj","jylivui","apfpfg","zhwopx","wirqyrqsyha","","pgxdbc","nbcerkvyzvy","eaynxqwqpu","","vpmqzwsgz","rqu","gmujhvyiy","kjwfqmwmcof","vkjcnsu","upxdtk","","qjrd","ayxgtwbifpg","zxydz","otva","","nishhxxv","hbsdjdn","","fzg","qzflhadrh","vf","qb","lpkbpqrtsf","abcfow","ju","knt","ixjvu","jkiquyipi","uoqwgk","gdkchpptusf","oceierx","zowcfu","mojgbhd","mukvcjk","mumtoui","","nmezfhtlmbe","fhgikgdr","","dyqvvp","fdwluk","","cnclf","","","thco","","wnfbdbgod","hc","sx","vcpfg","wbexz","xlxg","ldri","mry","pgngxd","qqbv","","xysx","htb","ixusevfzma","ofwluw","ytnsfulldau","wevcfd","qyurmlo","dxy","dqb","wqrvuqheeqr",""});
	}
	
}