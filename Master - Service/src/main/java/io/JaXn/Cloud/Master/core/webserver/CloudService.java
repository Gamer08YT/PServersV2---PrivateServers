/*
 * Creator Jan Heil
 * (C) 2018 All rights reserved!
 * Support => Skype: janheil_2 / Teamspeak: NeXusplayZ.EU
 */

package io.JaXn.Cloud.Master.core.webserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.JaXn.Cloud.Master.Launcher;

import java.io.IOException;
import java.io.OutputStream;

public class CloudService implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "<!doctype html>\n" +
                "<html lang=\"de\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>JaXnCloud V0.1.0 | Developer Panel</title>\n" +
                "\n" +
                "    <!-- Compiled and minified CSS -->\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css\">\n" +
                "\n" +
                "    <!-- Compiled and minified JavaScript -->\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js\"></script>\n" +
                "\n" +
                "    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n" +
                "    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js\"></script>\n" +
                "    <script src=\"http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js\"></script>\n" +
                "    <!--Page Loader-->\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<nav>\n" +
                "    <div class=\"nav-wrapper navbar-colour light-blue darken-2\">\n" +
                "        <a href=\"#\" class=\"brand-logo\">&nbsp;&nbsp;&nbsp;JaXnCloudV1 - <b>DevPanel</b></a>\n" +
                "        <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\n" +
                "            <li><a href=\"http://royalbyte.net/clouds\">Donwload Cloud</a></li>\n" +
                "            <li><a href=\"/about\">About</a></li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "</nav>\n" +
                "<p></p>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"progress\">\n" +
                "        <div class=\"indeterminate\"></div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"col s12 m8 offset-m1 xl7 offset-xl1\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col s4\">\n" +
                "            <div class=\"center promo promo-example\">\n" +
                "                <i class=\"large material-icons blue-text\">flash_on</i>\n" +
                "                <p class=\"promo-caption\">Speeds up Building</p>\n" +
                "                <p class=\"light center\">We're trying to provide the best possible cloud to enable networks to deliver a feature rich and well-developed cloud.</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col s4\">\n" +
                "            <div class=\"center promo promo-example\">\n" +
                "                <i class=\"large material-icons blue-text\">group</i>\n" +
                "                <p class=\"promo-caption\">User Experience Focused</p>\n" +
                "                <p class=\"light center\">We try to make our Cloud lag free as well as simple in their functions.</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col s4\">\n" +
                "            <div class=\"center promo promo-example\">\n" +
                "                <i class=\"large material-icons blue-text\">settings</i>\n" +
                "                <p class=\"promo-caption\">Easy to work with</p>\n" +
                "                <p class=\"light center\">We have provided detailed documentation as well as specific installation / code examples to help new users get started.</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"row center\">\n" +
                "            <div class=\"col s4\">\n" +
                "                <div class=\"col s12 m7\">\n" +
                "                    <h2 class=\"header\">Master Service</h2>\n" +
                "                    <div class=\"card horizontal\">\n" +
                "                        <div class=\"card-stacked\">\n" +
                "                            <div class=\"card-content\">\n" +
                "                                <h5>Threads: </h5>\n" +
                "                                <h5>Port: </h5>" + Launcher.QuerryPort + "\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        <div class=\"col s4\">\n" +
                "            <div class=\"col s12 m7\">\n" +
                "                <h2 class=\"header\">Proxy Service</h2>\n" +
                "                <div class=\"card horizontal\">\n" +
                "                    <div class=\"card-stacked\">\n" +
                "                        <div class=\"card-content\">\n" +
                "                            <h5>100% UPTIME</h5>\n" +
                "                            <h5>Port: </h5>" + Launcher.ProxyPort + "\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"col s4\">\n" +
                "            <div class=\"col s12 m7\">\n" +
                "                <h2 class=\"header\">Web Service</h2>\n" +
                "                <div class=\"card horizontal\">\n" +
                "                    <div class=\"card-stacked\">\n" +
                "                        <div class=\"card-content\">\n" +
                "                           <h5>100% UPTIME</h5>\n" +
                "                            <h5>Port: </h5>" + Launcher.WebservicePort
+ "\n" +                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "        </div>\n" +
                "       </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<footer class=\"page-footer navbar-colour light-blue darken-2\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col l6 s12\">\n" +
                "                <h5 class=\"white-text\">JaXnCloudV1 - DevPanel</h5>\n" +
                "                <p class=\"grey-text text-lighten-4\">Software for Cloud Network Environment Technology </p>\n" +
                "            </div>\n" +
                "            <div class=\"col l4 offset-l2 s12\">\n" +
                "                <h5 class=\"white-text\">Links</h5>\n" +
                "                <ul>\n" +
                "                    <li><a class=\"grey-text text-lighten-3\" href=\"http://royalbyte.net/\">Webshop</a></li>\n" +
                "                    <li><a class=\"grey-text text-lighten-3\" href=\"http://NeXusPlayZ.EU/cloud/author.html\">Developer</a></li>\n" +
                "                    <li><a class=\"grey-text text-lighten-3\" href=\"https://discord.gg/8NDNDxh\">Discord Server</a></li>\n" +
                "                    <li><a class=\"grey-text text-lighten-3\" href=\"http://nexusplayz.eu/partner.html\">Partner</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"footer-copyright\">\n" +
                "        <div class=\"container\">\n" +
                "            (c) 2018 Jan H. / Gamer08\n" +
                "            " +
                "        </div>\n" +
                "    </div>\n" +
                "</footer>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
