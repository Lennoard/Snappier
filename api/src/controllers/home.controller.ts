import { Request, Response } from "express";

const json = {
  id: "snappier_scaffold",
  contents: [
    {
      scaffold: {
        elements: [
          {
            contents: [
              {
                backgroundColor: "#FFFFFF",
                foregroundColor: "#354f90",
                icons: [
                  {
                    color: "#acadad",
                    description: "Feed",
                    events: [
                      {
                        action: {
                          data: "app://social-feed",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ],
                    size: 24,
                    token: "feed"
                  },
                  {
                    color: "#acadad",
                    description: "Friend Requests",
                    events: [
                      {
                        action: {
                          data: "app://social-friendship-request",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ],
                    size: 24,
                    token: "friends"
                  },
                  {
                    color: "#acadad",
                    description: "Messages",
                    events: [
                      {
                        action: {
                          data: "app://social-messages",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ],
                    size: 24,
                    token: "message"
                  },
                  {
                    color: "#acadad",
                    description: "Notifications",
                    events: [
                      {
                        action: {
                          data: "app://social-notifications",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ],
                    size: 24,
                    token: "world"
                  },
                  {
                    color: "#acadad",
                    description: "Options",
                    events: [
                      {
                        action: {
                          data: "app://social-notifications",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ],
                    size: 24,
                    token: "menu"
                  }
                ]
              }
            ],
            id: "social-tab"
          },
          {
            contents: [
              {
                backgroundColor: "#cfd2d8",
                cards: [
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://samplelib.com/lib/preview/png/sample-boat-400x300.png"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Emily White 🏰"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Just now"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "Have a great weekend everyone!"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/01",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?auto=compress&cs=tinysrgb&w=600"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "John Smith"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "2:28 PM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "The CEO of TakeMeOut just got arrested!!!???💀💀\n😲😲😲😲😲\nOMG, what is going on, huh??\nI used the app so much!!!😭😭😭😭😭😭😭"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/02",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://i.ytimg.com/vi/_jHIXqbGVX4/maxresdefault.jpg"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "MessiasCivicK20"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "7:43 AM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "😎😎😎"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/03",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/1043471/pexels-photo-1043471.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://www.cnnbrasil.com.br/wp-content/uploads/sites/12/2024/06/vini-e1717275504772.jpeg?w=1080"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "~~John Michael~~"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Yesterday, 10:55 PM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "Go, our star boy!"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/04",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/1310522/pexels-photo-1310522.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://media.istockphoto.com/id/1324844508/photo/gorgeous-woman-wearing-beautiful-maxi-dress-posing-against-wall-with-a-wild-grape.jpg?s=612x612&w=0&k=20&c=BJrcuLt0m5Hm6zOhgO-E0TGqIxzWKdecgw1xcOu1aN4="
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Michelle S. Miller"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Just now"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "💃"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/05",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/34534/people-peoples-homeless-male.jpg?auto=compress&cs=tinysrgb&w=600"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Mark Vincent"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Tuesday, 10:20 PM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "🎶\n\"I remember a time\nMy frail, virgin mind\nWatched the crimson sunrise\nImagined what it might find\nLife was filled with wonder\nI felt the warm wind blow\nI must explore the boundaries\nTranscend the depth of winter's snow\""
                        }
                      ],
                      videos: [
                        {
                          autoPlay: false,
                          description: "A Change of Seasons",
                          hideControls: true,
                          url: "https://androidvip.com.br/snappier/sample/video/acos.mp4"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/06",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://samplelib.com/lib/preview/png/sample-clouds2-400x300.png"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Lucas Smith"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Yesterday, 10:32 AM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "My homeland is so beautiful!!!"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/01",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/943084/pexels-photo-943084.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://thumbor.forbes.com/thumbor/fit-in/1290x/https://www.forbes.com/advisor/wp-content/uploads/2023/09/getty_creative.jpeg.jpg"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Lucy Miller"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Just now"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "She has been doing very well recently, thank you to everyone who helped!"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/01",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/718978/pexels-photo-718978.jpeg?auto=compress&cs=tinysrgb&w=600"
                        },
                        {
                          constraints: {
                            height: 180,
                            width: -1
                          },
                          scaleType: "crop",
                          url: "https://s2.glbimg.com/Ha2q-YYa3pCWtwM4E51zi_p-POI=/940x523/e.glbimg.com/og/ed/f/original/2019/02/20/blow-dry-bar-del-mar-chairs-counter-853427.jpg"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Mary Dianne"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "2:56 PM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "Make your appointment 😉"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/01",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  },
                  {
                    backgroundColor: "#FFFFFF",
                    border: {
                      percent: 5
                    },
                    content: {
                      buttons: [
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://like/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Like",
                            size: 14,
                            token: "thumbsup"
                          },
                          title: "Like"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://comment/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Comment icon",
                            size: 14,
                            token: "message"
                          },
                          title: "Comment"
                        },
                        {
                          backgroundColor: "#0000000000",
                          color: "#acadad",
                          events: [
                            {
                              action: {
                                data: "app://share/01",
                                type: "LocalNavigation"
                              },
                              trigger: "OnClick"
                            }
                          ],
                          icon: {
                            color: "#acadad",
                            description: "Share icon",
                            size: 14,
                            token: "share"
                          },
                          title: "Share"
                        }
                      ],
                      images: [
                        {
                          constraints: {
                            height: 40,
                            width: 40
                          },
                          scaleType: "crop",
                          url: "https://images.pexels.com/photos/3094215/pexels-photo-3094215.jpeg?auto=compress&cs=tinysrgb&w=600"
                        }
                      ],
                      texts: [
                        {
                          color: "#000000",
                          fontWeight: 700,
                          size: 16,
                          text: "Julia Newman"
                        },
                        {
                          color: "#bbbec1",
                          fontWeight: 400,
                          size: 12,
                          text: "Yesterday, 1:37 PM"
                        },
                        {
                          color: "#323232",
                          fontWeight: 400,
                          size: 14,
                          text: "Is it just me or did you guys also notice that all internet services went down this week?"
                        }
                      ]
                    },
                    events: [
                      {
                        action: {
                          data: "app://social-post/01",
                          type: "LocalNavigation"
                        },
                        trigger: "OnClick"
                      }
                    ]
                  }
                ]
              }
            ],
            id: "social-feed"
          }
        ],
        isNavigationDrawerLayout: false,
        topBar: {
          backgroundColor: "#354f90",
          icons: [
            {
              color: "#FFFFFF",
              description: "Search",
              events: [
                {
                  action: {
                    data: "app://social-search",
                    type: "LocalNavigation"
                  },
                  trigger: "OnClick"
                }
              ],
              size: 24,
              token: "search"
            },
            {
              color: "#FFFFFF",
              description: "My account",
              events: [
                {
                  action: {
                    data: "app://social-account",
                    type: "LocalNavigation"
                  },
                  trigger: "OnClick"
                },
                {
                  action: {
                    data: "My account",
                    type: "ShowShortMessage"
                  },
                  trigger: "OnLongCLick"
                }
              ],
              size: 24,
              token: "person"
            }
          ],
          title: {
            color: "#FFFFFF",
            fontWeight: 700,
            size: 18,
            text: "News Feed"
          }
        }
      }
    }
  ]
}

export function home(req: Request, res: Response): Response {
  return res.json(json);
}
