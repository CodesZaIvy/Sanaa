package com.ivy.sanaa.art.application.outlook.taskbar;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopTaskbar<MenuLink> implements Menu, Serializable {
    private final List<MenuLink> links = new ArrayList<>();

    {
        Object MenuLinkStatus;
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./artworks", "Artworks", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./exhibitions", "Exhibitions", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./artists", "Artists", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./about", "About", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./contact", "Contact", MenuLinkStatus.NOT_ACTIVE));
    }

    @Override
    public String menu(int activeLinkIndex){
        this.activateLink(activeLinkIndex);

        String menubar = "<div class=\"topnav\">";

        Object MenuLinkStatus;
        for(MenuLink link : links)
            menubar += "<a " + (link.getStatus() == MenuLinkStatus.ACTIVE ? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";
        menubar += "</div>";
        return menubar;
    }

    public void activateLink(int linkIndex){
        for(int index = 0; index<links.size(); index++){
            Object MenuLinkStatus;
            if(index == linkIndex)
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
        }
    }
}


