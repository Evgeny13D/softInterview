<#-- @ftlvariable name="participant" type="A402.model.Participant" -->
<#-- @ftlvariable name="event" type="A402.model.Event_NV" -->
<#-- @ftlvariable name="event_date" type="java.util.Date" -->
<#setting time_format="HH:mm">
<#setting date_format="dd/MM/YYYY">
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>A402</title>

    <style type="text/css">
        /* Client-specific Styles */
        #outlook a {padding:0;} /* Force Outlook to provide a "view in browser" menu link. */
        body{width:100% !important; -webkit-text-size-adjust:100%; -ms-text-size-adjust:100%; margin:0; padding:0;}
        /* Prevent Webkit and Windows Mobile platforms from changing default font sizes, while not breaking desktop design. */
        .ExternalClass {width:100%;} /* Force Hotmail to display emails at full width */
        .ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {line-height: 100%;} /* Force Hotmail to display normal line spacing.*/
        #backgroundTable {margin:0; padding:0; width:100% !important; line-height: 100% !important;}
        img {outline:none; text-decoration:none;border:none; -ms-interpolation-mode: bicubic;}
        a img {border:none;}
        .image_fix {display:block;}
        p {margin: 0px 0px !important;}
        table td {border-collapse: collapse;}
        table { border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; }
        a {color: #0a8cce;text-decoration: none;text-decoration:none!important;}
        /*STYLES*/
        table[class=full] { width: 100%; clear: both; }
        /*IPAD STYLES*/
        @media only screen and (max-width: 640px) {
            a[href^="tel"], a[href^="sms"] {
                text-decoration: none;
                color: #0a8cce; /* or whatever your want */
                pointer-events: none;
                cursor: default;
            }
            .mobile_link a[href^="tel"], .mobile_link a[href^="sms"] {
                text-decoration: default;
                color: #0a8cce !important;
                pointer-events: auto;
                cursor: default;
            }
            table[class=devicewidth] {width: 440px!important;text-align:center!important;}
            table[class=devicewidthinner] {width: 420px!important;text-align:center!important;}
            img[class=banner] {width: 440px!important;height:220px!important;}
            img[class=colimg2] {width: 440px!important;height:220px!important;}


        }
        /*IPHONE STYLES*/
        @media only screen and (max-width: 480px) {
            a[href^="tel"], a[href^="sms"] {
                text-decoration: none;
                color: #0a8cce; /* or whatever your want */
                pointer-events: none;
                cursor: default;
            }
            .mobile_link a[href^="tel"], .mobile_link a[href^="sms"] {
                text-decoration: default;
                color: #0a8cce !important;
                pointer-events: auto;
                cursor: default;
            }
            table[class=devicewidth] {width: 280px!important;text-align:center!important;}
            table[class=devicewidthinner] {width: 260px!important;text-align:center!important;}
            img[class=banner] {width: 280px!important;height:140px!important;}
            img[class=colimg2] {width: 280px!important;height:140px!important;}
            td[class=mobile-hide]{display:none!important;}
            td[class="padding-bottom25"]{padding-bottom:25px!important;}

        }
    </style>
</head>
<body>
<!-- Start of preheader -->
<table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="preheader" >
    <tbody>
    <tr>
        <td>
            <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                <tbody>
                <tr>
                    <td width="100%">
                        <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                            <tbody>
                            <tr>
                                <td width="100%" height="10"></td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100" align="right" border="0" cellpadding="0" cellspacing="0" class="devicewidth">
                                        <tbody>
                                        <tr>
                                            <td width="30" height="30" align="right">
                                                <div class="imgpop">
                                                    <a target="_blank" href="#">
                                                        <#--<img src="facebook.png" alt="" border="0" width="30" height="30" style="display:block; border:none; outline:none; text-decoration:none;">-->
                                                    </a>
                                                </div>
                                            </td>
                                            <td align="left" width="20" style="font-size:1px; line-height:1px;">&nbsp;</td>
                                            <td width="30" height="30" align="center">
                                                <div class="imgpop">
                                                    <a target="_blank" href="#">
                                                        <#--<img src="twitter.png" alt="" border="0" width="30" height="30" style="display:block; border:none; outline:none; text-decoration:none;">-->
                                                    </a>
                                                </div>
                                            </td>
                                            <td align="left" width="20" style="font-size:1px; line-height:1px;">&nbsp;</td>
                                            <td width="30" height="30" align="center">
                                                <div class="imgpop">
                                                    <a target="_blank" href="#">
                                                        <#--<img src="linkedin.png" alt="" border="0" width="30" height="30" style="display:block; border:none; outline:none; text-decoration:none;">-->
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td width="100%" height="10"></td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
<table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="header">
    <tbody>
    <tr>
        <td>
            <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                <tbody>
                <tr>
                    <td width="100%">
                        <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                            <tbody>
                            <tr>
                                <td height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="140" align="center" border="0" cellpadding="0" cellspacing="0" class="devicewidth">
                                        <tbody>
                                        <tr>
                                            <td width="169" height="45" align="center">
                                                <div class="imgpop">
                                                    <a target="_blank" href="#">
                                                        <#--<img src="logo3" alt="" border="0" width="100" height="100" style="display:block; border:none; outline:none; text-decoration:none;">-->
                                                        <p src="logo3" alt="" border="0" width="100" height="100" style="display:block; border:none; outline:none; text-decoration:none;">A402</p>
                                                    </a>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    </tbody>
</table>
<table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="banner">
    <tbody>
    <tr>
        <td>
            <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                <tbody>
                <tr>
                    <td width="100%">
                        <table width="600" align="center" cellspacing="0" cellpadding="0" border="0" class="devicewidth">
                            <tbody>
                            <tr>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="seperator">
                <tbody>
                <tr>
                    <td>
                        <table width="600" align="center" cellspacing="0" cellpadding="0" border="0" class="devicewidth">
                            <tbody>
                            <tr>
                                <td align="center" height="20" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="full-text">
                <tbody>
                <tr>
                    <td>
                        <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                            <tbody>
                            <tr>
                                <td width="100%">
                                    <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                                        <tbody>
                                        <tr>
                                            <td height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table width="560" align="center" cellpadding="0" cellspacing="0" border="0" class="devicewidthinner">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-family: Helvetica, arial, sans-serif; font-size: 30px; color: #333333; text-align:center; line-height: 30px;" st-title="fulltext-heading">
                                                            Вас приветсвует А402.
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="100%" height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="font-family: Helvetica, arial, sans-serif; font-size: 16px; color: #666666; text-align:center; line-height: 30px;" st-content="fulltext-content">
                                                            У нас скоро будет проходить новый тренинг. И вот немного информации о нем.
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>

                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="seperator">
                <tbody>
                <tr>
                    <td>
                        <table width="600" align="center" cellspacing="0" cellpadding="0" border="0" class="devicewidth">
                            <tbody>
                            <tr>
                                <td align="center" height="30" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td width="550" align="center" height="1" bgcolor="#d1d1d1" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center" height="30" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="full-text">
                <tbody>
                <tr>
                    <td>
                        <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                            <tbody>
                            <tr>
                                <td width="100%">
                                    <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <table width="560" align="center" cellpadding="0" cellspacing="0" border="0" class="devicewidthinner">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-family: Helvetica, arial, sans-serif; font-size: 16px; color: #666666; text-align:center; line-height: 30px; font-weight: bolder;" st-content="fulltext-content">
                                                        ${event.nameRu}
                                                        </td>
                                                    </tr>
                                                    <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="banner">
                                                        <tbody>
                                                        <tr>
                                                            <td>
                                                                <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                                                                    <tbody>
                                                                    <tr>
                                                                        <td width="100%">
                                                                            <table width="600" align="center" cellspacing="0" cellpadding="0" border="0" class="devicewidth">
                                                                                <tbody>
                                                                                <tr>
                                                                                    <!-- start of image -->
                                                                                    <td align="center" st-image="banner-image">
                                                                                        <div class="imgpop">
                                                                                            <#--<a target="_blank" href="#"><img width="600" border="0" height="300" alt="" border="0" style="display:block; border:none; outline:none; text-decoration:none;" src="ImageGetter.png" class="banner"></a>-->
                                                                                        </div>
                                                                                    </td>
                                                                                </tr>
                                                                                </tbody>
                                                                            </table>
                                                                            <!-- end of image -->
                                                                        </td>
                                                                    </tr>
                                                                    </tbody>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                    <tr>
                                                        <td width="100%" height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="font-family: Helvetica, arial, sans-serif; font-size: 16px; color: #666666; text-align:left; line-height: 30px;" st-content="fulltext-content">
                                                            Мероприятие состоится ${event_date?date}  по адресу ${event.locationRu}, ${event.addressRu}.
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td style="font-family: Helvetica, arial, sans-serif; font-size: 16px; color: #666666; text-align:left; line-height: 30px;" st-content="fulltext-content">
                                                            Время проведения ${event.startTime?time} - ${event.endTime?time}.
                                                        </td>
                                                    </tr>

                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="seperator">
                <tbody>
                <tr>
                    <td>
                        <table width="600" align="center" cellspacing="0" cellpadding="0" border="0" class="devicewidth">
                            <tbody>
                            <tr>
                                <td align="center" height="30" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td width="550" align="center" height="1" bgcolor="#d1d1d1" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center" height="30" style="font-size:1px; line-height:1px;">&nbsp;</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="postfooter" >
                <tbody>
                <tr>
                    <td>
                        <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                            <tbody>
                            <tr>
                                <td width="100%">
                                    <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                                        <tbody>
                                        <tr>
                                            <td align="center" valign="middle" style="font-family: Helvetica, arial, sans-serif; font-size: 14px;color: #666666" st-content="postfooter">
                                                Больше информации можно узнать <a href="http://a402.by/showEvent?eventId=${event.id}" style="text-decoration: none; color: #0a8cce">перейдя сюда</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="100%" height="20"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <table width="100%" bgcolor="#ffffff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="full-text">
                <tbody>
                <tr>
                    <td>
                        <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                            <tbody>
                            <tr>
                                <td width="100%">
                                    <table width="600" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth">
                                        <tbody>
                                        <tr>
                                            <td height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table width="560" align="center" cellpadding="0" cellspacing="0" border="0" class="devicewidthinner">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-family: Helvetica, arial, sans-serif; font-size: 16px; color: #666666; text-align:center; line-height: 30px;" st-content="fulltext-content">
                                                            A402 © 2018 | All Rights Reserved
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="20" style="font-size:1px; line-height:1px; mso-line-height-rule: exactly;">&nbsp;</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>


</body>
</html>