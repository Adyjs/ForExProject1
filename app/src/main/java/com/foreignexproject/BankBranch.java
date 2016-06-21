package com.foreignexproject;

public class BankBranch
{
    String bankName , addressStr ;
    String []
            Keelung=new String[]{}, Taipei=new String[]{}, Xinbei=new String[]{} , Taoyuan=new String[]{} , Hsinchu=new String[]{},
            Miaoli=new String[]{}, Taichung=new String []{},Changhua=new String[]{},Nantou=new String[]{},Yunlin, Chiayi=new String[]{},
            Tainan=new String[]{} , Taitung=new String[]{} ,Kaohsiung=new String[]{}, Pingtung=new String[]{},Yilan=new String[]{},
            Hualien=new String[]{},Penghu=new String[]{},Kinmen=new String[]{},Lienchiang=new String[]{} ;


    
    public BankBranch(String bankName ,String addressStr)
    {
        this.bankName=bankName;
        this.addressStr=addressStr;
    }

    public String[]  getMarkList()
    {
        String[] markList={};
        String [] notFound=null;
        if(bankName.contains("台灣銀行"))
        {
            bankOfTaiwan();

            if(addressStr.contains("台"))
            {
                if(addressStr.contains("台北"))
                {
                    markList=Taipei;
                }
                if(addressStr.contains("台中"))
                {
                    markList=Taichung;
                }
                if(addressStr.contains("台南"))
                {
                    markList=Tainan;
                }
                if(addressStr.contains("台東"))
                {
                    markList=Taitung;
                }
            }
            else if(addressStr.contains("新")) {
                if (addressStr.contains("新北")) {
                    markList = Xinbei;
                }
                if (addressStr.contains("新竹")) {
                    markList = Hsinchu;
                }
            }
            else if(addressStr.contains("桃園"))
            {
                markList=Taoyuan;
            }
            else if(addressStr.contains("基隆"))
            {
                markList=Keelung;
            }
            else if(addressStr.contains("苗栗"))
            {
                markList=Miaoli;
            }
            else if(addressStr.contains("彰化"))
            {
                markList=Changhua;
            }
            else if(addressStr.contains("南投"))
            {
                markList=Nantou;
            }
            else if(addressStr.contains("雲林"))
            {
                markList=Yunlin;
            }
            else if(addressStr.contains("嘉義"))
            {
                markList=Chiayi;
            }
            else if(addressStr.contains("高雄"))
            {
                markList=Kaohsiung;
            }
            else if(addressStr.contains("屏東"))
            {
                markList=Pingtung;
            }
            else if(addressStr.contains("宜蘭"))
            {
                markList=Yilan;
            }
            else if(addressStr.contains("花蓮"))
            {
                markList=Hualien;
            }
            else if(addressStr.contains("澎湖"))
            {
                markList=Penghu;
            }
            else if(addressStr.contains("金門"))
            {
                markList=Kinmen;
            }
            else if(addressStr.contains("連江"))
            {
                markList=Lienchiang;
            }
            else
            {
                return notFound;
            }
        }
        return markList;
    }

    public void bankOfTaiwan()
    {
        Keelung=new String [] {"基隆市中正區義一路16號"};
        Taipei =new String [] {"台北市中正區館前路49號","台北市大同區南京西路406號","台北市中山區中山北路一段150號","台北市中正區南昌路一段120號",
                "台北市中正區羅斯福路四段120號","台北市北投區中央南路一段152號","台北市北投區中央南路一段152號","台北市中正區青島東路47號",
                "台北市大同區承德路二段239號","台北市中山區松江路115號","台北市萬華區康定路380號","台北市大安區敦化南路一段202號",
                "台北市大安區信義路二段88號","台北市信義區忠孝東路四段560號","台北市士林區中山北路六段197號","台北市松山區復興北路167號",
                "台北市信義區基隆路一段333號3樓301室","台北市大安區敦化南路2段69號","台北市松山區敦化北路205號1樓","台北市南港區南港路二段95號1樓",
                "台北市大安區和平東路一段180號"};
        Xinbei=new String []{"新北市板橋區府中路21號","新北市三重區重新路四段39號","新北市中和區建一路186號一、二樓","新北市中和區中山路二段253號",
                "新北市新莊區新泰路85號","新北市樹林區文化街29號","新北市新店區寶中路45號","新北市板橋區中山路一段293-2號","新北市土城區中央路二段344號",
                "新北市五股區中興路四段42號","新北市淡水區中山路93號","新北市汐止區大同路二段175號1樓","新北市蘆洲區三民路50號","新北市板橋區中山路一段161號地下一樓",
                "新北市八里區商港路123號2樓","新北市板橋區文化路一段268號","新北市永和區仁愛路97號","新北市新莊區中正路653號",
                "新北市新莊區頭前路119號1樓及121號1-3樓"};
        Taoyuan=new String []{"桃園市桃園區中正路46號","桃園市中壢區延平路580號","桃園市大園區埔心村航站南路15號","桃園市平鎮區環南路二段11號",
                "桃園市蘆竹區南崁路一段81號","桃園市中壢區興農路125號","桃園市中壢區健行路169號","桃園市桃園區經國路300號","桃園市龍潭區東龍路142號",
                "桃園市龜山區復興一路368號","桃園市桃園區延平路28-8號","桃園市中壢區新明路7號"};
        Hsinchu=new String []{"新竹縣竹北市光明六路16號","新竹縣竹北市光明六路東一段312號","新竹市東區林森路29號","新竹市東區工業東六路5號2樓",
                "新竹市東區北大路68號"};
        Miaoli=new String []{"苗栗縣苗栗市中正路510號","苗栗縣頭份鎮中正路65號"};
        Taichung=new String []{"台中市西區自由路一段140號","台中市豐原區中正路302號","台中市霧峰區中正路838號","台中市潭子區建國路1號",
                "台中市東區復興路四段102號","台中市梧棲區四維路2號","台中市中區臺灣大道一段276號","台中市大甲區民生路61號","台中市南屯區大業路607號",
                "台中市大雅區中清路三段1080號1至5樓及地下1樓","台中市西屯區工業區一路196號","台中市北屯區崇德路二段416號","台中市大里區國光路二段481號",
                "台中市西屯區青海路二段41號","台中市梧棲區中港加工出口區建五路2號","台中市太平區中興東路146號","台中市大里區德芳路一段63號",
                "台中市大雅區中科路6號2樓之5、之6","台中市北區太平路17號","台中市西區民權路95號"};
        Changhua=new String []{"彰化縣彰化市成功路130號","彰化縣員林鎮民生路63號","彰化縣鹿港鎮鹿工路2號1樓"};
        Nantou=new String []{"南投縣南投市中興新村光華路11號","南投縣南投市復興路101號","南投縣埔里鎮東榮路112號"};
        Yunlin=new String []{"雲林縣斗六市文化路27號","雲林縣虎尾鎮林森路二段369號"};
        Chiayi=new String []{"嘉義縣太保市祥和新村祥和一路東段2號","嘉義市西區中山路306號","嘉義市西區忠孝路602號","嘉義市西區中興路353號"};
        Tainan=new String []{"台南市永康區小東路513號","台南市安南區安和路2段298號","台南市仁德區中正路2段899號",
                "台南市中西區府前路一段155號","台南市新市區南科三路15號1樓","台南市安南區工業二路31號",
                "台南市新營區中正路10號","台南市中西區中正路240號","台南市中西區忠義路二段180號","台南市永康區中正南路41號"};
        Kaohsiung=new String []{"高雄市前金區中正四路264號","高雄市前鎮區高雄加工出口區中一路1號","高雄市鳳山區曹公路20號","高雄市左營區左營大路19號",
                "高雄市前鎮區擴建路1之3號","高雄市鼓山區臨海一路23號","高雄市三民區九如二路567號","高雄市岡山區壽天路16號","高雄市新興區民族二路133號",
                "高雄市苓雅區青年一路261號","高雄市苓雅區新光路142號","高雄市楠梓區楠梓路201號","高雄市三民區九如一路540號","高雄市鳳山區五甲二路168號",
                "高雄市左營區裕誠路394號","高雄市大寮區鳳屏一路339號","高雄市小港區宏平路410號","高雄市小港區中山四路2號國際航廈一樓","高雄市路竹區路科五路23號1-3樓",
                "高雄市左營區重信路415號"};
        Pingtung=new String []{"屏東縣屏東市中山路43號","屏東縣潮州鎮新生路13-2號","屏東縣東港鎮新勝街105號1-3樓","屏東縣屏東市中華路9號",
                "屏東縣長治鄉德和村農科路23號","屏東縣新園鄉仙吉村仙吉路65號"};
        Yilan=new String []{"宜蘭縣宜蘭市舊城南路50號","宜蘭縣羅東鎮公正路93號","宜蘭縣蘇澳鎮中山路1段97號"};
        Hualien=new String []{"花蓮縣花蓮市公園路3號","花蓮縣花蓮市林森路281號一、二樓"};
        Taitung=new String []{"台東縣台東市中山路313號"};
        Penghu=new String []{"澎湖縣馬公市仁愛路24號"};
        Kinmen=new String []{"金門縣金湖鎮復興路4號"};
        Lienchiang=new String []{"連江縣南竿鄉介壽村257號"};
    }


}