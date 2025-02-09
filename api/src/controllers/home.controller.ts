import { Request, Response } from "express";

const json = {
  id: "snappier_scaffold",
  contents: [
    {
      scaffold: {
        elements: [
          {
            id: "snappier_text",
            contents: [
              {
                texts: [
                  {
                    text: "Scaffold content from Snappier API!",
                    size: 48,
                    fontWeight: 700,
                    alignment: "center",
                    constraints: {
                      width: -1
                    }
                  }
                ]
              }
            ]
          }
        ],
        floatingElement: {
          id: "snappier_fab",
          contents: [
            {
              fab: {
                backgroundColor: "#FF9800",
                text: {
                  text: "Extended action",
                  size: 16,
                  color: "#123321",
                  fontWeight: 600
                },
                icon: {
                  size: 24,
                  token: "cart",
                  color: "#00EEFA",
                  events: [
                    {
                      trigger: "OnClick",
                      action: {
                        data: "app://cart",
                        type: "LocalNavigation"
                      }
                    }
                  ]
                },
                stroke: {
                  width: 4,
                  color: "#661142"
                },
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
            }
          ]
        },
        isNavigationDrawerLayout: true,
        topBar: {
          backgroundColor: "#FF9800",
          title: {
            text: "TopBar App Name",
            size: 24,
            fontWeight: 700,
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
