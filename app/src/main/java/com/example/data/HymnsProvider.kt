package com.example.data

object HymnsProvider {
    fun getHymns(): List<Hymn> {
        return listOf(
            // --- SHONA HYMNS ---
            Hymn(
                number = 1,
                title = "M'TSVENE, M'TSVENE, M'TSVENE",
                key = "Key e 4/4",
                lyrics = listOf(
                    "1. M'tsvene, M'tsvene, M'tsvene, Mwari wemasimba\nTinomuku. . mbira Pa. . .mangwanani ese\nM'tsvene, M'tsvene, M'tsvene, mune nyasha huru\nMumwe va. . ta. .tu Pamwe chete zve",
                    "2. M'tsvene. M'tsvene, M'tsvene, Vese vano. . . daro\"\nVakahwa. . .rira Pamberi penyu Mwari\nM'tsvene, M'tsvene, M'tsvene, Vano. . . munamata\nMa. . ka. .nge muri Muno. .zova zve",
                    "3. M'tsvene, M'tsvene, M'tsvene, Zvese zvakasikwa\nZvinokudza imi Mu. . . kuru kune vese\nM'tsvene, M'tsvene, M'tsvene, Makamisa misi\nMu. .ri mu. .pe. .nyu Nemu. .siki zve"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 2,
                title = "JESU NDISHAMWARI WEDU",
                key = "Key = f 3/4",
                lyrics = listOf(
                    "1. Jesu ndishamwari wedu Mununuri wakanaka\nTinokomborerwa kwazvo Tine hama yakadai\nKuti tichi mukumbira Anofadzwa kupindura\nAnotipa zvakanaka Hatichazo shayi chiro",
                    "2. Kuti tine dambudziko Kana tinerurunziro\nHatizovi ne u .. rombo Tinotenda kuna Ishe\nHativoni imwe hama Yakanaka kunge Jesu\nAnotenda vanhu ve .. se Mukumbire anokunzwa",
                    "3. Kuti tisisine simba Rekuita basa rake\nJe…su anotipa simba Rekuita basa rake\nKana kuti takatukwa Tinonyararidzwa naye\nJesu ndishamwari wedu Rudo rwake rwakanaka"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 3,
                title = "ZUVA RANGU MUPONESI",
                key = "Key = f 3/4",
                lyrics = listOf(
                    "1. Zuva ra. . ngu Mu. . po. . ne. . si\nKuno pe. . nya A. . . po mu. . .ri\nNdirambi. . . dzei Zva. . ka. . i. . pa\nZvino zo. . . ndi dzi. . . Ka. . ti. . ra",
                    "2. Apo ho. . pe Dza. . ndi. . bata\nNdichenge. . tei Ngu. . va dzo. . se\nGara. . i neni Pa. . u. . si. . ku\nDzamara mu. . ru. . fu rwa. . ngu",
                    "3. Ndikombo. . re. . re Ndichamu. . ka\nNdisati nda. . . Enda kuba. . sa\nNdichana. . ka Ne. . pa. . nzi. . ra\nDakara ndi. .svi. . ke Kude. . .nga"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 4,
                title = "KUEDZA KWAZO SVIKA",
                key = "Key = b flat 4/4",
                lyrics = listOf(
                    "1. Kuedza kwazo. . svika Kwa dzinga rima rese\nVamuka vanhu vese Kudzidza Jesu kristu\nMasoko akanaka O uya misi yese\nEkuti vadzi mambo Vanoda vafundisi",
                    "2. Vonayi vanhu vazhinji Vanoda kudzidziswa\nKufamba mune nzira yavanhu vakanaka\nMajaya ne mhandara Vanoda ruponeso\nVaBaba ne vamayi Vanoda nzira istva",
                    "3. Rwasvika ruponeso RwaMwari nyika dzese\nRwofadza kure kure kumadzinza ese ese\nTapota imi Baba Pamsana pake Jesu\nKuvaponesa avo Vagere mune rima"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 5,
                title = "TINOMUSHUMIRAI",
                key = "Doh = Bb 4/4",
                lyrics = listOf(
                    "1. Tinomushumirai, Nhasi zuva renyu!\nPatiri douyai, Nhasi zuva renyu!\nSHE nyasha mutipei, Neropa tisukei,\nRigotinatsa sei, Nhasi zuva renyu!",
                    "2. Tonyengetera SHE Nhasi zuva re. . nyu!\nNesu vo, mutinzwei, Nhasi zuva re. . nyu!\nPazvivi tirwirei, SHE, Mutibetserei,\nTigozvivenga sei, Nhasi zuva re. . nyu!",
                    "3. Nzwi renyu torinzwa. Nhasi zuva re. . nyu\nToda kuterera , Nhasi zuva re .. nyu!\nTifadzwe, SHE, naro, Ribaye moyo vo,\nRigare ipapo, Nhasi zuva re. . nyu!"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 6,
                title = "ISHE JESU MOSE RUMBIDZAI",
                key = "Key Doh =Bb 4/4",
                englishTitle = "All hail, the power of Jesus's name",
                lyrics = listOf(
                    "1. ISHE Jesu mose rumbidzai Vatumwa gwadamai!\nZvou Ishe hwake farirai! Kudza ISHE imi mose\nlye ISHE kudzai!",
                    "2. Vasunungurwa , tarirai ISHE wenyu , chimudai;\nNezvipo zvenyu chiuyai; Kudzai ISHE, imi mose;\nlye ISHE kudzai!",
                    "3. Gwayana raIshe chivongai Mufiri chitendai:\nChangeto yenyu farai!\nKudzai ISHE, imi mose\nlye ISHE kudzai!",
                    "4. Ikoko kuchanzi farai, Huyai chigwadamai!\nVarwirwa vose, pfugamai!\nKudzai ISHE , imi mose; lye ISHE kudzai!"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 7,
                title = "JESU SHE MUPENYU!",
                key = "Key 2/2",
                englishTitle = "Jesus lives! Thy terrors now",
                lyrics = listOf(
                    "1. Jesu SHE mupenyu! Hakuchina zvino tyisa\nWatipa upenyu, Shungu dzose wakapisa\nHareruya!",
                    "2. Jesu SHE mupenyu! Zvino suwo roupenyu\nRashamira isu Tozosvika'po parufu!\nHareruya!",
                    "3. Jesu SHE mupenyu! Watifira tomutenda, Unonatsa isu;\nNdiye watinokudzisa,\nHareruya!",
                    "4. Jesu SHE: mupenyu! Rudo rwake rwatibata;\nHakuchine chinhu Chotigurisa ukama.\nHareruya!",
                    "5. Jesu SHE mupenyu! Wakabata ushe hose;\nNgatisiye zvedu, Kundofara naye chose,\nHareruya!"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 8,
                title = "NDINOSIMUDA, SHE",
                key = "Key = Ab 3/4",
                englishTitle = "Need Thee every hour",
                lyrics = listOf(
                    "1. Ndinosimuda, SHE! Kundi betsera;\nNzwi renyu ndigonzwa Kundinyaradza",
                    "Chorus:\nNdotsvaka imi moga Mwoy' wangu womushuva\nNditaririre Jesu ndinyaradzei!",
                    "2. Ndinosimuda, SHE! Sara - i neni;\nNdingazokunda vo Muri pandiri!",
                    "3. Ndinosimuda, SHE! Pandinofara;\nPandotambura vo Musandisiya!",
                    "4. Ndinosimuda, SHE! Ndinatswe chose;\nNdimushumire vo; Nomoyo wose!"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 9,
                title = "BABA NDINOFARA KWAZVO",
                key = "Key = b flat 3/4",
                lyrics = listOf(
                    "1. Baba ndinofara kwazvo, Kuti ndidaidzwe nemi\nNdakagara muzvitema Ndika pera kusvipiswa\nAsi hamusaka ramwa Makandida zvenyu Baba",
                    "2. Baba kunakayi kwenyu Nhamburiko dzakaitwa\nKunditsvaka pasi pano Ndikawona ndiri kufa\nNdikaitwa uno. . pona Tenzi ndinomutevera.",
                    "3. Kuti mune basa renyu Iro ndingagone kuita\nNdingafadzwa kuriita Ndisingadi muripiro\nNdinodisa Kubatsira, lmi Basi tenzi wangu"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 10,
                title = "TENZI ARI MUNO",
                key = "Key e 4/4",
                lyrics = listOf(
                    "1. Tenzi ari. . muno Mumba yake tsvene\nIsu vanhu te. . se Ngatinyara. . rise",
                    "2. Apo tichi .. muno Ngainzwikwe zvino\nMikumbiro ye. . du Takanyara. . risa",
                    "3. Muparidzi wedu Ngaapiwe zvino\nMazwi anogutsa Mwoyo yedu nhasi",
                    "4. Tenzi tiri .. muno Mumba yenyu tsvene\nTakagariri. . ra Takanyara. . risa.",
                    "5. Apo tichi .. muno Tino mukumbira\nTigadziri. . reyi Kunzwa izwi renyu",
                    "6. Apo tichi .. muno Tikomborereyi\nTifarisi. . seyi Tikwadzani. . seyi."
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 11,
                title = "NDAKAITIRWE NYASHA HURU",
                key = "Key = G 3/4",
                lyrics = listOf(
                    "1. Ndakaitirwa nyasha huru Inyasha dzaShe dzogadzo\nNdiMuponesi wanguzve Zve inyasha dzakandipa She\nRinenge riri nenji guru She Jesu wandifirawo",
                    "2. Ndakanga ndisina kunaka Bva zvino ndashanduka sei\nNdakanga ndawanirwa - mhaka Ini ndaidziripa nei?\nNdiJesu wandinatsa zve, Inyasha dzake, lye SHE!",
                    "3. SHE Jesu, ndinotenda zvose Zvenyasha dzamakandipa!\nNdichanyepera vanhu vose Ndichiti : Jesu watida!\nNdoshuva kuti vamude Vatsvake nyasha dzenyu SHE!",
                    "4. SHE Jesu wangu wounyoro Mundipe nyasha dzenyu zve;\nMugondisvitsa vo kumsoro Kudenga kwamuri’imi SHE\nKwandi chandomuvonga zve Zvandakapiwa nemi SHE!"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 12,
                title = "CHIUNGANAI",
                key = "Key = c 3/4",
                lyrics = listOf(
                    "1. Chiunganai Tikudze Tenzi wedu\nChisumukai Tivambe nziyo dzedu\nHareruya Hareruya!",
                    "2. Chifara - i SHE wakatiponesa!\nBva chikudza - i Wakatiraramisa\nTimukudzei, timukudzei!",
                    "3. Chimuvonga - i Nokuti zvirokwazvo\nMuchingoda - i Munomufadza nazvo\nUnozvida, unozvida!",
                    "4. Chiterera - i Nemi masara sure\nChiswedera - i Mamirire- i kure?\nTiimbisei! tiimbisei!",
                    "5. Chibvumira- i Nemi vo ndudzi dzose!\nChirumbidza- i SHE wamadzishe ose\nHareruya! Harereuya!"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 13,
                title = "MWARI NGAAVE NEMI MESE",
                key = "Key = d 4/4",
                lyrics = listOf(
                    "1. Mwari ngaave nemi mose Dakara tisangane zve\nAmutungamirireyi Mwari ngaave nemi mose",
                    "2. Mwari ngaave nemi mose Ndiye unomuchengeta\nMunopiwa mose Kudya Mwari ngaave nemi mose",
                    "3. Mwari ngaave nemi mose Apo mune madambudzo\nMunozobatsirwa naye Mwari ngaave nemi mose",
                    "Chorus:\nKuti tisangane (tose) Kuti tisanganezve naJesu\nKuti tisangane (tose) Mwari ngaave nemi mose"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 14,
                title = "JESU MURI ZIBWE'RO",
                key = "Key = e 4/4",
                lyrics = listOf(
                    "1. Jesu muri zibwe’ro Randi tsemukira ‘ni\nMvura nemaropa zve Zvabva parutivi'po\nNgazvishambe mwoyo'yu Ndibve mune mhosva ini",
                    "2. Handiunze zvipoba Ndino tenda kuna Ishe\nHandisakanakaba Handina masimba ba\nNdino bhururuka ini Ndisukeyi ndisafe",
                    "3. Apo ndararamawo Rufu runouya wo\nKuti ndobhururuka Kune denga dzvene ro\nZibwe reruponeso Ngandi vande kune'mi."
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 15,
                title = "BABA WEVESE TINOTENDA",
                key = "Key = g 4/4",
                lyrics = listOf(
                    "1. Baba wevese tinotenda Nemangwanani nehusiku\nNeruzororo neruchengeto Nezvinofadza upenyu hwedu",
                    "2. Tinomutenda nezvekudya Nezviro zvese zvatinazvo\nNdizvo nemwoyo inotendeka Tinomudisa mazuva ese",
                    "3. Asi zvikuru tinotenda Nemurumbwana wenyu Jesu\nAkatifira kutiponesa Nekutitora Kudenga rake",
                    "4. Tibatsireyi misi yese Kugara zvakanakisisa\nTinoda mwoyo yakarurama inofanana nerudo rwenyu"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 16,
                title = "UNGATORA HAKO PASI",
                key = "Key = f 3/4",
                lyrics = listOf(
                    "1. Ungatora hako pasi Nerufaro rwapo rwese\nNdinotora hangu Jesu Nerufaro rwake rwese",
                    "2. Ungatora hako pasi Neupfumi hwapo hwese\nNdinofadzwa naye Jesu Haazondinyimi chiro",
                    "Chorus:\nTsitsi dzake zhinji zhinji Dzinokwana kune vese\nRuponeso runopiwa Kune vanhu vake vose"
                ),
                category = "SHONA"
            ),

            // --- NEW SHONA SONGS / SECTION ---
            Hymn(
                number = 203,
                title = "DOMBO RINE SIMBA",
                key = "Key = g 4/4",
                lyrics = listOf(
                    "1. Rukariro urwo rwangu\nRusimbire kuna Jesu\nHandidawiri nemunhu\nAsi zita raJesu",
                    "Chorus:\nNdinomirira pana Jesu\nNdiye dombo nheyo yangu\nKunwe kwese kunonyudza",
                    "2. Kuti awigwa nedima\nTsitsi dzake ndogarira\nMumhepo huru yesimba\nRuwoko rwake ndobata",
                    "3. Chiranagano chake icho\nNechitsidzo cheropa\nZvinondipa rusimbiso\nPakati pematambudziko",
                    "4. Apo anenge auya\nNetsuri ichazoridzwa\nNdinoda kuti ndimire\nNaJesu parudyi rwake"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 204,
                title = "PASI PANO TINOCHEMA",
                key = "Key = d 4/4",
                lyrics = listOf(
                    "1. Pasi pano tinochema\nTinorwadzwa ndisatani\nTinoedzwa zvirokwazvo\nTichitambudzika kwazvo\nAsi tinoziva kuti\nPano handi musha wedu\nTichaenda kune nyika\nKuna Baba wakanaka",
                    "Chorus:\nPano handimusha wedu\nTinoziva imwe nyika\nTinoenda nekufara\nIyo tiri kudaidzwa",
                    "2. Takaiswa pasi pano\nNemusiki wedu Mwari\nKuti tizogadzirira\nNge’yo nzvimbo yakanaka\nIyo Jesu akaenda\nKofanira kukadzira\nAkatisiyira izwi\n“Ndichadzoka kumutora”.",
                    "3. Kuti tichishaya kudya\nNemafaro akanaka\nKana hama dzativenga\nDzatituka zvirokwazvo\nTina hama yakanaka\nInogara pakudenga\nKgadzira nzimbo yedu."
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 212,
                title = "BABA WEDU MAKATSIDZA",
                key = "Key = a flat 4/4",
                lyrics = listOf(
                    "1. Baba wedu makatsidza ndinokutungamirira\nKuti usarasikeba ndinokutungamirira",
                    "Chorus:\nNdinokutungamirira ndinokutungamirira\nPakukwira kune denga ndinokutungamirira",
                    "2. Apo unotambudzika nekushaya zano riya\nUnofunga ayo manzwi ndinokutungamirira",
                    "3. Kuti hama dzako dzafa uchidzichemera kwazvo\nUnofunga aya manzwi ndinokutungamirira",
                    "4. Apo unokomborerwa mwoyo wako unofara\nUnodisa aya manzwi ndinokutungamirira",
                    "5. Mangwanani ese ese unofunga aya manzwi\nEchitsidzo chakanaka ndinokutungamirira",
                    "6. Apo unorara pasi pausiku uri wega\nUnotenda aya manzwi ndinokutungamirira",
                    "7. Apo unobata basa unofunga manzwi ake\nUyo wakakutsidzira ndinokutungamirira"
                ),
                category = "SHONA"
            ),
            Hymn(
                number = 220,
                title = "INYASHA DZAMWARI",
                key = "Key = g 4/4",
                lyrics = listOf(
                    "1. Kuti tive pano Inyasha dzaMwari\nInyasha dzaMwari\nInyasha dzaMwari",
                    "2. Kukura kwedu tese Inyasha dzaMwari\nTisambo zvikudza\nHausi uchenjeri",
                    "3. Kudzidza kwedu tese Inyasha dzaMwari\nTisambo zvikudza\nInyasha dzaMwari",
                    "4. Misha yatinayo Inyasha dzaMwari\nTisambo zvikudza\nHausi uchenjeri",
                    "5. Muruma waunaye Inyasha dzaMwar!\nTisambo zvikudza\nInyasha dzaMwari",
                    "6. Mukadzi waunaya Inyasha dzaMwari\nTisambo zvikudza\nHausi uchenjeri",
                    "7. Vana vatinavo Inyasha dzaMwari\nTisambo zvikudza\nInyasha dzaMwari"
                ),
                category = "SHONA"
            ),

            // --- CHEWA SONGS ---
            Hymn(
                number = 1,
                title = "KWATU SIPADZIKO",
                key = "Chewa No. 1 (371)",
                lyrics = listOf(
                    "1. Kwatu sipadziko, ndingo pitirira,\nNdadzikundikira chuma Kumwambako\nMngelo akodola pakhomo la m'Mwamba;\nNdipo dziko lapansi sindiyesa kwathu,",
                    "Chorus:\nMbuye, ndinu bwenzi langa ndithu\nNdichitenj i ngati Kumwamba si kwatu?\nMngelo akodola pakhomo la m'Mwamba;\nNdipo dziko lapansi sindiyesa kwathu.",
                    "2. Andiyembezeka, chinthuchi ndidziwa,\nMpulumutsi wan ga wand ikhulukira;\nAdzandipyoletsa pamene ndafoka;\nNdipo dziko lapansi sindiyesa kwathu.",
                    "3. Mayi watsogola ku Ulemerero,\nNdifunakuqwira dzanja lake konko,\nAndidikiranso pakhomo la m'Mwamba;\nNdipo dziko lapansi .sindiyesa kwathu.",
                    "4. Mu ulemelelo tidzakhala mlyaya,\nQyemtiwawo alikulambila;\nAti, \"Aleluya kwa Mlungu Wamphamvu.\"\nNdipo dziko lapansi sindiyesa kwathu"
                ),
                category = "CHEWA"
            ),
            Hymn(
                number = 2,
                title = "MUNDIMVERE",
                key = "Chewa No. 2 (234)",
                lyrics = listOf(
                    "1. Mundimvere, Mbuye wanga\nNkana ine ndimalakwa,\nKoma ndinu moyo wanga;\nMbuye, mkhale ndine.",
                    "2. Ndine mlendo pansi pano,\nMsanditaye m’dzanja lanu,\nMundisunge mwanal wanu;\nMbuye, mkhale ndine.",
                    "3. Munafera ine kaIe\nKuti mukandimasule,\nLero lino mndinyamule\nMbuye, mkhale ndine.",
                    "4. Mundidzaze ndi chikondi,\nMndiyeretse m’mtima monse,\nChifiniro change mthyole;\nMbuye, mkhale ndine",
                    "5. Imfa ikandifikira,\nInu ndidzakangamira:\nNdikalowa ine m'mdima,\nMbuye, mkhale ndine."
                ),
                category = "CHEWA"
            ),
            Hymn(
                number = 3,
                title = "NDIIMBA",
                key = "Chewa No. 3 (137)",
                lyrics = listOf(
                    "1. Ndiimba mumtima mokondwa\nNdi nyimbo yokoma, yoyera;\nNdiimba za Jesu Mbuyanga,\nAnditonthoza \"ne phee!",
                    "Chorus:\nChete! Chete!\nM'mtima mtendereme phee!\nUdzera kwa Jesu wokonda\nMtendere mumtimamu.",
                    "2. Pamtanda Mbuyanga 'nafera,\nAkandichotsere zochinwa;\nA nandigulira mtendere,\nMbuye, mkhale ndine.",
                    "3. Pomlambira Jesu Mbuyanga,\nMurntima mtendere walowa;\nNdalitso woposa ndapeza,\nMbuye, mkhale ndine.",
                    "4. Pokonda Yesuyo., mtendere!\nKunthawi zosatha, mtendere!\nPotsata Mbuyanga apatsa\nMtendere mumtimamu."
                ),
                category = "CHEWA"
            ),
            Hymn(
                number = 4,
                title = "MSANDIPITIRIRE",
                key = "Chewa No. 4 (46)",
                lyrics = listOf(
                    "1. Msandipitirire, Jesu\nMundimvere ine,\nMulikudalitsa ene’\nMsandipitirire.",
                    "Chorus:\nYesu Mbuye,\nKhutu munditchere\nM'mene muitana ena\nMsandipitirire",
                    "2. Ndigwadira inu Jesu\nMusandikanize;\nNdikalapatu machimo\nMbuye, mndithandize",
                    "3. Nkhope yanu ndifunitsa,\nSind’yenera konse;\nN’mtima mwanga muchiritse\nNthenda zanga zonse",
                    "4. Jesu, ndinutu chitsime\nCha chimwemwe chokha;\nSindufunga wina konse,\nKoma Inu nokha."
                ),
                category = "CHEWA"
            ),
            Hymn(
                number = 5,
                title = "IDZA WOLEMA",
                key = "Chewa No. 5 (47)",
                lyrics = listOf(
                    "1. Idza wolema, Akupumitsa\nWomva chisoni, Akutonthoza;\nMlendo, limbika, Mphamvu apatsa;\nAmatisunga Jesu Ambuya",
                    "2. Ndiye matsamiro, Pogona ine;\nPofika kufa, Anditsutsanso;\nPodzichepedza Andikwezanso;\nMoyo wa moyo, Jesu Ambuye.",
                    "3. Ndikakhumundwa Andilimbitssa;\nNdikadzitama Andichepetsa\nNdikasikera; Andilondola;\nE! Wokonderdwa, Jesu Ambuye.",
                    "4. Ndimachitira Inu umboni;\nNdikukuzani Moyamikira;\nMphamvu ndi nzeru Moya, zonsezi,\nSi zanga, nzanu, Jesu Ambuye"
                ),
                category = "CHEWA"
            ),
            Hymn(
                number = 6,
                title = "LIMBA MTIMBA",
                key = "Chewa No. 6 (174)",
                lyrics = listOf(
                    "1. Limba mtima mbale wanga,\nUsapunthwe m' njirayi;\nOnatu nyenyezi ija\nIkutsogoleradi\nTamveratu Mlungu yekha,\nChita zolungama 'we,\nYenda bwino, Khulupirira\nMbuyeyo, Mbuyeyo,\nNdi kuchita zakezi.",
                    "2. Taya zako zochenjera,\nTaya zamundimanso;\nNthawi zonse khulupira.\nChita zolungamazo.\nUsayang'anire wina\nM'khondo yako yomweyi,\nKoma mzonse khulupira\nMbuyeyo. Mbuyeyo,\nNdi kuchita zakezi.",
                    "3. Leka zakuipa zako,\nMyambi yonse yoti bii,\nUsakhulupire mommo;\nTamveratu Mbuyedi.\nAdzadana nawe ena,\nEna adzakonda 'we;\nKweza maso, khulupirira\nMbuyeyo, Mbuyeyo,\nNdi kuchita zakezi.",
                    "4. Mawu ake atipatsa\nMpamvu ndi mtenderenso.\nBwino atitsogolera,\nTikhulupirira 'wo.\nLimba mtima, usapunthwe\nM'njira yamumdimayi;\nYenda bwino, khulupirira\nMbuyeyo, Mbuyeyo,\nNdi kuchita zakezi."
                ),
                category = "CHEWA"
            ),

            // --- NDEBELE SONGS ---
            Hymn(
                number = 1,
                title = "SINGABAHAMBAYO EMHLABENI",
                key = "Ndebele No. 1 (327)",
                lyrics = listOf(
                    "1. Slnqabahambayo Emhlabeni\nKepha sinekhaya Ezulwini,\nNoma sisahaqwa Ingozi nosizi,\nSithi akunjalo Ezulwini.",
                    "2. Noma sisabethwa Isiphepho\nNgenxa yakho, Jesu Nkosi yethu,\nIsikhathi lesi Esihiushwa ngaso\nSophela masinya, Nenhlupeko.",
                    "3. Lapho kuMsindisi, Ezulwini;\nAbamlandeleyo Emhlabeni;\nBophumula naye, Kanye nabangcwele\nNabathandiweyo, Ezulwini.",
                    "4. Thina bakaKristu Emhlabeni\nSobheka ekhaya, Ezulwini,\nSize sidle ifa Esiliphiwayo,\nIfa lokuphila Ezulwini,"
                ),
                category = "NDEBELE"
            ),
            Hymn(
                number = 2,
                title = "SINOMHLOBO ONGUJESU",
                key = "Ndebele No. 2 (75)",
                lyrics = listOf(
                    "1. Sinomhlobo ongu Jesu, Unothando;\nAkanjengeminy' im’hlobo, Unothando;\nAkanayo injabiso Akanayo inkohliso,\nUyasiza ngeqiniso; Unothando:",
                    "2. Ungumhlobo weth' uJesu Unothando;\nAkadel' abantu bakhe, Unothando;\nUbahola endleleni, Ubagcina engozini,\nUbakhipha osizini Unothando;",
                    "3. Sezomuka emhlabeni Wabathanda;\nSetekhona ezulwini,Ubathanda;\nUbalungisela khona, Uyabahlalela bona,\nWobamkela banke khona Ngaluthando.",
                    "4. Nina niyamdinga yini? Unothando.\nKade nihlupheka yini? Unothando.\nKungezono zenu yini?\nEnilahlwa ngazo yini?\nWonikhipa kuzo yena; Unothando;",
                    "5. Loluthando, hawu, lukhulu, Siyabona;\nMasimthande 'he kakhulu. Osithanda,\nNgalo masihambe sonke;\nNgalo sokwahlula konke;\nLuyadul olunye lonke, Loluthando."
                ),
                category = "NDEBELE"
            ),
            Hymn(
                number = 3,
                title = "DUMISANI, BANTU NONKE",
                key = "Ndebele No. 3 (42)",
                lyrics = listOf(
                    "1. Dumisani, bantu nonke!\nZidumis' izintu zonke!\nNamhla ngumhla wendumiso,\nNamhla ngumhla wethabiso:",
                    "2. Umkululi usezelwe,\nUbusiso Iwehlisiwe;\nNamhla ububele bukho,\nNamhla insindiso ikho.",
                    "3. Akezanga ngal ushaba;\nHambisani lezindaba:\nUze kithi ngobubele,\nUze yen' ukusifela ..",
                    "4. Hambisani lezindaba: .\nZiye kuwo wonk' umhlaba.\nBongani, bantu, nonke!\nZiyabong' izinto zonke."
                ),
                category = "NDEBELE"
            ),
            Hymn(
                number = 4,
                title = "MANGISONDELE",
                key = "Ndebele No. 4 (281)",
                lyrics = listOf(
                    "1. Mangisondele Kuwena, Nkosi,\nNoma nqiqhutshwa Inhlupheko, Nkos’,\nNgingathokoza; Ngiphinda ngithi-nje,\nUngisondeze, Nkos’, Kuwe manje,",
                    "2. Noma ngehleiwa Ngokubi Nkosi\nNgilel etsheni Ngihlupheka, Nkosi’,\nEmaphushweni Njalo nngingathi-nje,\nUngisondeze, Nkos, Kuwe manje,",
                    "3. Ngibonise, O Nkosi yam’,\nUkuthi konke Okukuwe Nkosi’,\nKuyizithunywa Zokungisiza-nje,\nUngisondez , Nkos’, Kuwe manje,",
                    "4. Nasekusni Ngobonga, Nkos’,\nNasosizini Ngodumisa, Nkos’,\nUma kungabe Ngokuhlupheka kwam'\nNgiyasondezwa, Nkosi Kuwe manje,",
                    "5. Noma ngidiza Ngethaba, Nkos’,\nNgiye phezulu Ezulwini, Nkos,\nNJalo ngovhuma, Ngiphinde ngiti-nje,\nUnqisondeza, Nkos’, Kuwe manje,"
                ),
                category = "NDEBELE"
            ),
            Hymn(
                number = 5,
                title = "YIMANI ISIBINDI",
                key = "Ndebele No. 5 (311)",
                lyrics = listOf(
                    "1. Yimani iSibindi, Mabutho akaJesu,\nUmkosi niwuh/abe, Ngayenganqotshwa qha.\nEquob' uyakunqoba Esabahol abanke,\nIzitha Wozinqoba, Abus' l’ndawo zonke.",
                    "2. YiMani iSibindi, Imbande nans’ikhala,\nYinani Eku/weni Kuseyinamhlanje;\nYibani-amaqawe, Nilwel’ iNkosi yenu;\nIgwal’ alingabikho, Yimani nithi ngo.",
                    "3. Yimel' uJesu Kristu, Yim’ emandleni akhe;\nIngalo enye ize, Neyenu ingesize.\nHlomani izikhali ZeNkosi yamankosi,\nNilinde, nighandaze, Nizodi' umvuzo wenu.",
                    "4. Yimani isibindi Sekuzophel' ukulwa,\nUmsindo wempi namhla Kobongwa, iNkosi ngomso;\nKobongwa namaqhqwe, Aphiwe nemiqhele,\nAbuse njalonjalo, NeNkosi nobunkosi"
                ),
                category = "NDEBELE"
            )
        )
    }
}
