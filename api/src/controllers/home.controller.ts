import { Request, Response } from "express";

const json = {
  id: "snappier_scaffold",
  contents: [
    {
      scaffold: {
        components: [
          {
            id: "snappier_text",
            contents: [
              {
                texts: [
                  {
                    text: "Scaffold content from Snappier API!",
                    size: 48,
                    weight: 700,
                    alignment: "cente",
                    constraints: {
                      width: -1
                    }
                  }
                ]
              }
            ]
          }
        ],
        floatingComponent: {
          id: "snappier_button",
          contents: [
            {
              events: [
                {
                  trigger: "OnClick",
                  action: {
                    data: "app://do-something",
                    type: "LocalNavigation"
                  }
                }
              ],
              buttons: [
                {
                  color: "#CFDA10",
                  backgroundColor: "#323232",
                  title: "Floating content",
                  events: [
                    {
                      trigger: "OnClick",
                      action: {
                        data: "app://do-something",
                        type: "LocalNavigation"
                      }
                    }
                  ]
                }
              ]
            }
          ]
        },
        isNavigationDrawerLayout: true,
        topBar: {
          backgroundColor: "#FF9800",
          title: {
            text: "TopBar App Name",
            size: 24,
            weight: 700,
            color: "#000000"
          },
          icons: [
            {
              size: 24,
              token: "favorite",
              color: "#00EEFA",
              events: [
                {
                  trigger: "OnClick",
                  action: {
                    data: "app://favorites",
                    type: "LocalNavigation"
                  }
                }
              ]
            },
            {
              size: 24,
              token: "settings",
              color: "#323232",
              events: [
                {
                  trigger: "OnClick",
                  action: {
                    data: "app://settings",
                    type: "LocalNavigation"
                  }
                }
              ]
            },
            {
              size: 24,
              token: "phone",
              color: "#225500",
              events: [
                {
                  trigger: "OnClick",
                  action: {
                    data: "app://call",
                    type: "LocalNavigation"
                  }
                }
              ]
            }
          ],
          navigationIcon: {
            size: 24,
            token: "menu",
            color: "#1A9A32"
          }
        },
        navigationItems: [
          {
            action: null,
            label: "Screen 1",
            color: "#654321",
            icon: {
              size: 32,
              token: "home",
              color: "#987654"
            }
          },
          {
            action: null,
            label: "Screen 2",
            color: "#123456",
            icon: {
              size: 32,
              token: "home",
              color: "#456789"
            }
          }
        ]
      }
    }
  ]
}

export function home(req: Request, res: Response): Response {
  return res.json(json);
}
