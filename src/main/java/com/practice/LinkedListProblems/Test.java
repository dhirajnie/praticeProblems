package com.practice.LinkedArrayListProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.practice.flatten.ESMessageContent;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;


public class Test{
    public static void main( String args[] ) throws ParseException {

     // String inp="[{ \"callbackurl\": \"http://dummy/url/ocr\", \"body\": \"{\\\"scanId\\\":\\\"1d9bf9fd-f68f-4e77-a980-18a19b1fc83e\\\",\\\"imageUrl\\\":\\\"https://s3-us-west-2.amazonaws.com/7ef3789c-113e-4475-b720-f2622d2741c2/1d9bf9fd-f68f-4e77-a980-18a19b1fc83e/1d9bf9fd-f68f-4e77-a980-18a19b1fc83e_image.jpg\\\",\\\"extractionConfidence\\\":\\\"60.2\\\",\\\"fields\\\":{\\\"currencyiso\\\":{\\\"confidence\\\":0.0,\\\"value\\\":\\\"unidentified\\\"},\\\"possibleMerchantName\\\":{\\\"confidence\\\":0.0,\\\"value\\\":[{\\\"value\\\":\\\"REFUND FORM\\\",\\\"operation\\\":\\\"POSSIBLE_MERCHANT_NAME_FROM_TOP\\\",\\\"matchedVicinity\\\":null,\\\"index\\\":0,\\\"confidence\\\":0.75,\\\"individualConfidence\\\":0.0,\\\"startX\\\":0,\\\"startY\\\":0,\\\"endX\\\":0,\\\"endY\\\":0,\\\"matchedValue\\\":null,\\\"tabularVal\\\":null},{\\\"value\\\":\\\"titanic belfast ltd\\\",\\\"operation\\\":\\\"BLOCK_BASED_MERCHANT_NAME\\\",\\\"matchedVicinity\\\":\\\"time ofsale\\\",\\\"index\\\":1,\\\"confidence\\\":0.75,\\\"individualConfidence\\\":0.0,\\\"startX\\\":0,\\\"startY\\\":0,\\\"endX\\\":0,\\\"endY\\\":0,\\\"matchedValue\\\":null,\\\"tabularVal\\\":null},{\\\"value\\\":\\\"taxfreeworldwide\\\",\\\"operation\\\":\\\"WEBSITE_DOMAIN_MERCHANT_NAME\\\",\\\"matchedVicinity\\\":null,\\\"index\\\":0,\\\"confidence\\\":0.7578431372549015,\\\"individualConfidence\\\":0.0,\\\"startX\\\":0,\\\"startY\\\":0,\\\"endX\\\":0,\\\"endY\\\":0,\\\"matchedValue\\\":\\\"www.taxfreeworldwide.com\\\",\\\"tabularVal\\\":null}]},\\\"merchantname\\\":{\\\"confidence\\\":0.0,\\\"value\\\":\\\"taxfreeworldwide\\\"},\\\"totalbillamount\\\":{\\\"confidence\\\":0.0,\\\"value\\\":7.0},\\\"receiptnumber\\\":{\\\"confidence\\\":1.0,\\\"value\\\":\\\"ectand\\\"},\\\"billingdate\\\":{\\\"confidence\\\":1.0,\\\"value\\\":\\\"06/04/18\\\"}},\\\"lineItems\\\":[],\\\"rawText\\\":\\\" - - - -\\r\\n TAX REFUND FORM\\r\\n ADMIT ONE REF: 3614737\\r\\n TAX FREE WORLDWIDE\\r\\n\\r\\n THIS IS A VAT407 FORM ISSUED BY\\r\\n AND SOLD TO\\r\\n TAX FREE WORLDWIDE UK LTD\\r\\n la The Chandlery\\r\\n 50 Westminster Bridge Road\\r\\n London, SE1 7QY\\r\\n Ph +44 207 612 1560\\r\\n www.taxfreeworldwide.com\\r\\n VAT Number: 812 3622 62\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n UI182120118141\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n 38000035008096\\r\\n\\r\\n RETAILER DECLARATION\\r\\n\\r\\nDate of Sale: 06/04/18\\r\\n Time ofSale: 13:11\\r\\n\\r\\n Titanic Belfast Ltd\\r\\n 1 Olympic Way\\r\\n QueenÆs Road\\r\\n +44 028 9076 6386\\r\\n VAT Number: 118 9116 12\\r\\n\\r\\n QUALIFYING GOODS\\r\\n\\r\\n Quantity and full description of goods\\r\\n including any serial numbers\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n 1 Titanic Bath Duck 4.00\\r\\n 1 Titanic Bath Duck 4.00\\r\\n 1 Titanic Collectors Waterball 6.00\\r\\n 1 Titanic Collectors Mini Tankard 5.00\\r\\n 1 Titanic Collectors Mini Tankard 5.00\\r\\n 1 Titanic CollectorsMini Tankard 5.00\\r\\n 1 Titanic White Cotton Bag 3.00\\r\\n 1 Titanic White Cotton Bag 3.00\\r\\n\\r\\n Price Inc Tax GBP 35.00\\r\\n THREE FIVE . ZERO ZERO\\r\\n Tax @ 20.00 GBP 7.00\\r\\n Admin Fee GBP 4.41\\r\\n\\r\\nRefund Amount GBP 2.59\\r\\n\\r\\n I declare that the details of this form are\\r\\ncorrectand that I am satisfied that the\\r\\n customer has completed and signed the form and\\r\\n that the customer detailed on this form is\\r\\n entitled to use the Vat retail export scheme.\\r\\n\\r\\n\\r\\nRetailer Signature:\\r\\n\\r\\n TOURIST DETAILS AND DECLARATION\\r\\n This section mustbe fully completed\\r\\n\\r\\n How would you like to get your refund?\\r\\n\\r\\n (1) Credit Card:\\r\\n Please provide Credit card\\r\\n to facilitate refund\\r\\n 435577856730 6489\\r\\n Refundwill be paid to the credit card number\\r\\nprovided above.\\r\\n\\r\\n (2) Other, please specify details:\\r\\n\\r\\n\\r\\n Name:ROSÉANN, Smic.Gowski. ...\\r\\n\\r\\n Permanent Address:\\r\\n\\r\\n..?.?.26.W.JARLATH IT...\\r\\nPostCode:......6.0.637....\\r\\n Country:......USA.........\\r\\nPassport or ID Number: 56.40.30.7.8.9...\\r\\n Issued by government of:...VJA.\\r\\nDate Arrived In EU:.....4- 5 - 1.8.......\\r\\n DateLeavingEU:.....2-13.:./ 8. ....\\r\\nEmailAddress: SCHmocÉldá @YAHoo.com\\r\\n Country offinal destination:.... V.S.A .\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n I declare that: I am notresident in the EU, or\\r\\n I am an EU residentwho intends to leave the EU\\r\\n for a minimum of 12 months, or I am a non-EU\\r\\n resident studying or working in the EU who\\r\\n intends to leave the EU for a minimum of 12\\r\\nmonths. I intend to export the goods listed on\\r\\n this form from the EU by the lastday of the\\r\\n third month following that in which they were\\r\\n purchased.\\r\\n I understand that when I present this form to\\r\\nHMRevenue & Customs, I am declaring that I am\\r\\nexporting all of the goods listed on this form\\r\\n from the EU. I will delete any goods listed\\r\\n that I decide to leave in the EU before I\\r\\npresent this form to HM Revenue & Customs.\\r\\n The information on this form is correct.\\r\\n\\r\\n Tourist Signature:\\r\\n\\r\\n Goseann Smugoweli.\\r\\n\\r\\n\\r\\n FOR OFFICIAL USE ATEXPORTFROM THE EU\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\nWarning: it is a seriousoffence to present\\r\\n this form and make an untrue declaration to HM\\r\\nRevenue & Customs if the goods are not exported\\r\\n fro the EU.\\r\\n Paymentmay not be authorised if the form is\\r\\nnot fully completed.\\r\\n\\r\\nDATA PROTECTION ACT 1998\\r\\nHow we use your information:\\r\\nHM Revenue & Customs is a data controller under\\r\\nthe data protection act 1998. Wehold\\r\\n information for the purposes specified in our\\r\\nnotification to the information commissioner,\\r\\n including the assessment and collection of tax\\r\\nand duties, the payments ofbenefits and the\\r\\nprevention and detection of crime and may use\\r\\nthis information for any of them.\\r\\nWemay get information aboutyou from others,\\r\\nor wemay give information to them. Ifwe do,\\r\\nit will only be as the law per t o\\r\\n-Check the accuracy of information\\r\\n-Preventor detect crime\\r\\n-Protectpublic funds\\r\\nWemay check information we receive about you\\r\\nwith what is already in our records. This can\\r\\n include information we receive aboutyou with\\r\\nwhat is already in our records. Thiscan\\r\\ninclude information provided by you, as well as\\r\\nby others, such as other government departments\\r\\nor agencies and overseas tax and customs\\r\\nauthorities. Wewillnot give information to\\r\\nanyone outside HM Revenue & Customs unless the\\r\\nlaw permits us to do so.\\r\\nFurther information can be found on our\\r\\nwebsite, www.hmrc.gov.uk or in our leaflet Data\\r\\nProtection.\\r\\n\\r\\n Revenue\\r\\n\\r\\n DA REŤAZLEA.COPY2018 TO\\r\\n\\r\\n TAX FREE WORLDWIDE cha\\r\\n ADMITONE REF: 3614737 eme\\r\\n\\r\\n Titanic Belfast Ltd\\r\\n 1 Olympic Way\\r\\n QueenÆs Road\\r\\n +44 028 9076 6386\\r\\n VAT Number: 118 9116 12\\r\\n\\r\\n THIS IS A VAT407 FORM ISSUED BY\\r\\n AND SOLD TO\\r\\n TAX FREE WORLDWIDE UK LTD\\r\\n 1a The Chandlery\\r\\n 50 Westminster Bridge Road\\r\\n London, SE1 7QY\\r\\n Ph +44 207 612 1560\\r\\n www.taxfreeworldwide.com\\r\\n VATNumber: 812 3622 62\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n\\r\\n UI182120118141\\r\\n\\r\\nDate ofSale: 06/04/18\\r\\n Time of Sale: 13:11\\r\\n\\r\\n 1 Titanic Bath Duck 4.00\\r\\n 1 Titanic Bath Duck 4.00\\r\\n 1 Titanic Collectors Waterball 6.00\\r\\n 1 Titanic Collectors Mini Tankard 5.00\\r\\n 1 Titanic Collectors Mini Tankard 5.00\\r\\n 1 Titanic CollectorsMini Tankard 5.00\\r\\n 1 Titanic White Cotton Bag 3.00\\r\\n 1 Titanic White Cotton Bag 3.00\\r\\n --- -- - -\\r\\nPrice Inc Tax GBP 35.00\\r\\n THREE FIVE , ZERO ZERO\\r\\n Tax @ 20.00 GBP 7.00\\r\\n\\\",\\\"licenseConsumed\\\":1}\", \"retriedCount\": 0, \"xConsumerCustomId\": \"InfrrdUser:26c57fc9-ee13-41fa-862e-ec913071ba2f,KongUsername:7ef3789c-113e-4475-b720-f2622d2741c2\", \"method\": \"POST\", \"maxRetry\": 6, \"retryTimeInterval\": 0, \"isExpired\": true, \"initialTimeStamp\": 1545301970706, \"timeForNextRetry\": 0, \"xrequestId\": \"1d9bf9fd-f68f-4e77-a980-18a19b1fc83e\", \"id\": \"77cdcbcd-3d9d-4d82-9475-87f6c2dfeeff\", \"header\": { \"Content-Type\": [ \"application/json\" ] } }]";
String inp="{\"callbackurl\":\"http://dummy/url/ocr\",\"body\":\"{\\\"scanId\\\":\\\"3f37c49d-c476-4e6f-850a-2f8d04e6d378\\\",\\\"imageUrl\\\":\\\"https://s3-us-west-2.amazonaws.com/7ef3789c-113e-4475-b720-f2622d2741c2/3f37c49d-c476-4e6f-850a-2f8d04e6d378/3f37c49d-c476-4e6f-850a-2f8d04e6d378_image.jpg\\\",\\\"extractionConfidence\\\":\\\"49.33\\\",\\\"fields\\\":{\\\"merchantname\\\":{\\\"confidence\\\":0.0,\\\"value\\\":\\\"taxfreeworldwide\\\"},\\\"totalbillamount\\\":{\\\"confidence\\\":0.0,\\\"value\\\":7.0},\\\"billingdate\\\":{\\\"confidence\\\":1.0,\\\"value\\\":\\\"06/04/18\\\"}},\\\"lineItems\\\":[{\\\"lineNumber\\\":1.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Bath Duck\\\",\\\"productId\\\":null,\\\"finalPrice\\\":4.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Bath Duck 4.00\\\"},{\\\"lineNumber\\\":2.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Bath Duck\\\",\\\"productId\\\":null,\\\"finalPrice\\\":4.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Bath Duck 4.00\\\"},{\\\"lineNumber\\\":3.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Collectors Waterball\\\",\\\"productId\\\":null,\\\"finalPrice\\\":6.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Collectors Waterball 6.00\\\"},{\\\"lineNumber\\\":4.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Collectors Mini Tankard\\\",\\\"productId\\\":null,\\\"finalPrice\\\":5.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Collectors Mini Tankard 5.00\\\"},{\\\"lineNumber\\\":5.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Collectors Mini Tankard\\\",\\\"productId\\\":null,\\\"finalPrice\\\":5.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Collectors Mini Tankard 5.00\\\"},{\\\"lineNumber\\\":6.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic CollectorsMini Tankard\\\",\\\"productId\\\":null,\\\"finalPrice\\\":5.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic CollectorsMini Tankard 5.00\\\"},{\\\"lineNumber\\\":7.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic White Cotton Bag\\\",\\\"productId\\\":null,\\\"finalPrice\\\":3.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic White Cotton Bag 3.00\\\"},{\\\"lineNumber\\\":8.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic White Cotton Bag\\\",\\\"productId\\\":null,\\\"finalPrice\\\":3.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic White Cotton Bag 3.00\\\"},{\\\"lineNumber\\\":9.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Admin Fee\\\",\\\"productId\\\":null,\\\"finalPrice\\\":4.41,\\\"confidence\\\":0.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" Admin Fee GBP 4.41\\\"},{\\\"lineNumber\\\":10.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Bath Duck\\\",\\\"productId\\\":null,\\\"finalPrice\\\":4.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Bath Duck 4.00\\\"},{\\\"lineNumber\\\":11.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Bath Duck\\\",\\\"productId\\\":null,\\\"finalPrice\\\":4.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Bath Duck 4.00\\\"},{\\\"lineNumber\\\":12.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Collectors Waterball\\\",\\\"productId\\\":null,\\\"finalPrice\\\":6.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Collectors Waterball 6.00\\\"},{\\\"lineNumber\\\":13.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Collectors Mini Tankard\\\",\\\"productId\\\":null,\\\"finalPrice\\\":5.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Collectors Mini Tankard 5.00\\\"},{\\\"lineNumber\\\":14.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic Collectors Mini Tankard\\\",\\\"productId\\\":null,\\\"finalPrice\\\":5.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic Collectors Mini Tankard 5.00\\\"},{\\\"lineNumber\\\":15.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic CollectorsMini Tankard\\\",\\\"productId\\\":null,\\\"finalPrice\\\":5.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic CollectorsMini Tankard 5.00\\\"},{\\\"lineNumber\\\":16.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic White Cotton Bag\\\",\\\"productId\\\":null,\\\"finalPrice\\\":3.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic White Cotton Bag 3.00\\\"},{\\\"lineNumber\\\":17.0,\\\"quantity\\\":1.0,\\\"quantityUnit\\\":\\\"ea\\\",\\\"unitPrice\\\":null,\\\"productName\\\":\\\"Titanic White Cotton Bag\\\",\\\"productId\\\":null,\\\"finalPrice\\\":3.0,\\\"confidence\\\":1.0,\\\"isCoupon\\\":false,\\\"rawText\\\":\\\" 1 Titanic White Cotton Bag 3.00\\\"}],\\\"rawText\\\":\\\"  -    -  -   -\\\\r\\\\n                  TAX  REFUND  FORM\\\\r\\\\n              ADMIT  ONE  REF:  3614737\\\\r\\\\n                TAX  FREE  WORLDWIDE\\\\r\\\\n\\\\r\\\\n         THIS  IS  A  VAT407  FORM  ISSUED  BY\\\\r\\\\n                    AND  SOLD  TO\\\\r\\\\n            TAX  FREE  WORLDWIDE  UK  LTD\\\\r\\\\n                  la  The  Chandlery\\\\r\\\\n            50  Westminster  Bridge  Road\\\\r\\\\n                 London,  SE1  7QY\\\\r\\\\n               Ph  +44  207  612  1560\\\\r\\\\n             www.taxfreeworldwide.com\\\\r\\\\n             VAT  Number:  812  3622  62\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n                  UI182120118141\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n                   38000035008096\\\\r\\\\n\\\\r\\\\n               RETAILER  DECLARATION\\\\r\\\\n\\\\r\\\\nDate  of  Sale:                             06/04/18\\\\r\\\\n Time  ofSale:                                13:11\\\\r\\\\n\\\\r\\\\n               Titanic  Belfast  Ltd\\\\r\\\\n                   1  Olympic  Way\\\\r\\\\n                    QueenÆs  Road\\\\r\\\\n                 +44  028   9076  6386\\\\r\\\\n             VAT  Number:  118  9116   12\\\\r\\\\n\\\\r\\\\n                  QUALIFYING  GOODS\\\\r\\\\n\\\\r\\\\n Quantity  and  full  description  of  goods\\\\r\\\\n including  any  serial  numbers\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n 1    Titanic  Bath  Duck                         4.00\\\\r\\\\n 1    Titanic  Bath  Duck                         4.00\\\\r\\\\n 1    Titanic  Collectors  Waterball            6.00\\\\r\\\\n 1    Titanic  Collectors  Mini  Tankard         5.00\\\\r\\\\n 1    Titanic  Collectors  Mini  Tankard         5.00\\\\r\\\\n 1    Titanic  CollectorsMini  Tankard         5.00\\\\r\\\\n 1    Titanic  White  Cotton  Bag                 3.00\\\\r\\\\n 1    Titanic  White  Cotton  Bag                 3.00\\\\r\\\\n\\\\r\\\\n Price  Inc  Tax                        GBP     35.00\\\\r\\\\n                            THREE  FIVE  .  ZERO  ZERO\\\\r\\\\n Tax  @  20.00                          GBP       7.00\\\\r\\\\n Admin  Fee                            GBP      4.41\\\\r\\\\n\\\\r\\\\nRefund  Amount                        GBP      2.59\\\\r\\\\n\\\\r\\\\n I  declare  that  the  details  of  this  form  are\\\\r\\\\ncorrectand  that  I  am  satisfied  that  the\\\\r\\\\n customer  has  completed  and  signed  the  form  and\\\\r\\\\n that  the  customer  detailed  on  this   form  is\\\\r\\\\n entitled  to  use  the  Vat  retail  export  scheme.\\\\r\\\\n\\\\r\\\\n\\\\r\\\\nRetailer  Signature:\\\\r\\\\n\\\\r\\\\n          TOURIST  DETAILS  AND  DECLARATION\\\\r\\\\n       This  section  mustbe  fully  completed\\\\r\\\\n\\\\r\\\\n How  would  you  like  to  get  your  refund?\\\\r\\\\n\\\\r\\\\n (1)  Credit  Card:\\\\r\\\\n            Please  provide  Credit  card\\\\r\\\\n                to  facilitate  refund\\\\r\\\\n   435577856730   6489\\\\r\\\\n Refundwill  be  paid  to  the  credit  card  number\\\\r\\\\nprovided  above.\\\\r\\\\n\\\\r\\\\n (2)  Other,  please  specify  details:\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n Name:ROSÉANN,  Smic.Gowski.  ...\\\\r\\\\n\\\\r\\\\n Permanent  Address:\\\\r\\\\n\\\\r\\\\n..?.?.26.W.JARLATH    IT...\\\\r\\\\nPostCode:......6.0.637....\\\\r\\\\n Country:......USA.........\\\\r\\\\nPassport  or  ID  Number:  56.40.30.7.8.9...\\\\r\\\\n Issued  by  government  of:...VJA.\\\\r\\\\nDate  Arrived  In  EU:.....4-  5  -  1.8.......\\\\r\\\\n DateLeavingEU:.....2-13.:./  8.  ....\\\\r\\\\nEmailAddress:  SCHmocÉldá  @YAHoo.com\\\\r\\\\n Country  offinal  destination:....  V.S.A  .\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n I  declare  that:  I  am  notresident  in  the  EU,  or\\\\r\\\\n I  am   an  EU  residentwho  intends  to  leave  the  EU\\\\r\\\\n for  a  minimum  of  12  months,  or  I  am  a  non-EU\\\\r\\\\n resident  studying  or  working  in  the  EU  who\\\\r\\\\n intends  to  leave  the  EU  for  a  minimum  of  12\\\\r\\\\nmonths.  I  intend  to  export  the  goods  listed  on\\\\r\\\\n this  form  from  the  EU  by  the  lastday  of  the\\\\r\\\\n third  month  following  that  in  which  they  were\\\\r\\\\n purchased.\\\\r\\\\n I  understand  that  when   I  present  this  form   to\\\\r\\\\nHMRevenue  &  Customs,  I  am  declaring  that  I  am\\\\r\\\\nexporting  all  of  the  goods  listed  on  this  form\\\\r\\\\n from  the  EU.  I  will  delete  any  goods  listed\\\\r\\\\n that  I  decide  to  leave  in  the  EU  before  I\\\\r\\\\npresent  this  form   to  HM  Revenue  &  Customs.\\\\r\\\\n The  information  on  this  form  is  correct.\\\\r\\\\n\\\\r\\\\n Tourist  Signature:\\\\r\\\\n\\\\r\\\\n   Goseann   Smugoweli.\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n      FOR  OFFICIAL  USE  ATEXPORTFROM  THE  EU\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\nWarning:  it  is  a  seriousoffence  to  present\\\\r\\\\n this  form  and  make  an  untrue  declaration  to  HM\\\\r\\\\nRevenue  &  Customs  if  the  goods  are  not  exported\\\\r\\\\n fro   the  EU.\\\\r\\\\n Paymentmay  not  be  authorised  if  the  form  is\\\\r\\\\nnot  fully  completed.\\\\r\\\\n\\\\r\\\\nDATA  PROTECTION  ACT  1998\\\\r\\\\nHow  we  use  your  information:\\\\r\\\\nHM  Revenue  &  Customs  is  a  data  controller  under\\\\r\\\\nthe  data  protection  act  1998.  Wehold\\\\r\\\\n information  for  the  purposes  specified  in  our\\\\r\\\\nnotification  to  the  information  commissioner,\\\\r\\\\n including  the  assessment  and  collection  of  tax\\\\r\\\\nand  duties,  the  payments  ofbenefits  and  the\\\\r\\\\nprevention  and  detection  of  crime  and  may  use\\\\r\\\\nthis  information   for  any  of  them.\\\\r\\\\nWemay  get  information   aboutyou  from  others,\\\\r\\\\nor  wemay  give  information  to   them.  Ifwe  do,\\\\r\\\\nit  will  only  be  as   the  law  per      t  o\\\\r\\\\n-Check  the  accuracy  of  information\\\\r\\\\n-Preventor  detect  crime\\\\r\\\\n-Protectpublic  funds\\\\r\\\\nWemay  check  information  we  receive  about  you\\\\r\\\\nwith  what  is  already  in  our  records.  This  can\\\\r\\\\n include  information  we  receive  aboutyou  with\\\\r\\\\nwhat  is  already  in  our  records.  Thiscan\\\\r\\\\ninclude  information  provided  by  you,  as  well  as\\\\r\\\\nby  others,  such  as  other  government  departments\\\\r\\\\nor  agencies  and  overseas  tax  and  customs\\\\r\\\\nauthorities.  Wewillnot  give  information  to\\\\r\\\\nanyone  outside  HM  Revenue  &  Customs  unless  the\\\\r\\\\nlaw  permits  us  to  do  so.\\\\r\\\\nFurther  information  can  be  found  on  our\\\\r\\\\nwebsite,  www.hmrc.gov.uk  or  in  our  leaflet  Data\\\\r\\\\nProtection.\\\\r\\\\n\\\\r\\\\n                     Revenue\\\\r\\\\n\\\\r\\\\n           DA   REŤAZLEA.COPY2018     TO\\\\r\\\\n\\\\r\\\\n                TAX  FREE  WORLDWIDE  cha\\\\r\\\\n              ADMITONE  REF:  3614737  eme\\\\r\\\\n\\\\r\\\\n                Titanic  Belfast  Ltd\\\\r\\\\n                   1  Olympic  Way\\\\r\\\\n                   QueenÆs  Road\\\\r\\\\n                +44  028  9076  6386\\\\r\\\\n             VAT  Number:  118  9116  12\\\\r\\\\n\\\\r\\\\n         THIS  IS  A  VAT407  FORM  ISSUED  BY\\\\r\\\\n                   AND  SOLD  TO\\\\r\\\\n            TAX  FREE  WORLDWIDE  UK  LTD\\\\r\\\\n                  1a  The  Chandlery\\\\r\\\\n            50  Westminster  Bridge  Road\\\\r\\\\n                 London,  SE1  7QY\\\\r\\\\n               Ph  +44  207  612  1560\\\\r\\\\n             www.taxfreeworldwide.com\\\\r\\\\n             VATNumber:  812  3622  62\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n\\\\r\\\\n                  UI182120118141\\\\r\\\\n\\\\r\\\\nDate  ofSale:                             06/04/18\\\\r\\\\n Time  of  Sale:                                13:11\\\\r\\\\n\\\\r\\\\n 1    Titanic  Bath  Duck                         4.00\\\\r\\\\n 1    Titanic  Bath  Duck                         4.00\\\\r\\\\n 1    Titanic  Collectors  Waterball            6.00\\\\r\\\\n 1    Titanic  Collectors  Mini  Tankard         5.00\\\\r\\\\n 1    Titanic  Collectors  Mini  Tankard         5.00\\\\r\\\\n 1    Titanic  CollectorsMini  Tankard         5.00\\\\r\\\\n 1    Titanic  White  Cotton  Bag                 3.00\\\\r\\\\n 1    Titanic  White  Cotton  Bag                 3.00\\\\r\\\\n                       ---  --   -    -\\\\r\\\\nPrice  Inc  Tax                        GBP      35.00\\\\r\\\\n                            THREE  FIVE  ,  ZERO  ZERO\\\\r\\\\n Tax  @  20.00                          GBP      7.00\\\\r\\\\n\\\",\\\"licenseConsumed\\\":1}\",\"retriedCount\":0,\"xConsumerCustomId\":\"InfrrdUser:26c57fc9-ee13-41fa-862e-ec913071ba2f,KongUsername:7ef3789c-113e-4475-b720-f2622d2741c2\",\"method\":\"POST\",\"isRetried\":false,\"maxRetry\":6,\"retryTimeInterval\":0,\"isExpired\":true,\"initialTimeStamp\":1545300182127,\"timeForNextRetry\":0,\"xrequestId\":\"3f37c49d-c476-4e6f-850a-2f8d04e6d378\",\"id\":\"6ff45bcf-652c-482c-a47d-38960db1f6ac\",\"header\":{\"Content-Type\":[\"application/json\"]}}";

    //    JSONObject object = (JSONObject) new JSONParser().parse(inp);
      //  System.out.println(object.get("body"));
    //    System.out.println(object.get("header"));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ESMessageContent es= objectMapper.readValue(inp,ESMessageContent.class);
            List<String> list = new ArrayList<>();

            list.add("application/json");
            Map<String,List<String>> header = new HashMap<>();
            header.put("application/json",list);
           // es.setHeaders(header);

            System.out.println();
           String output = objectMapper.writeValueAsString(es);
         //   System.out.println(object);
           System.out.println(output);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
