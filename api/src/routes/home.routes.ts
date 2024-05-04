import { Router } from "express";
import { home } from "../controllers/home.controller"

class HomeRoutes {
  router = Router();

  constructor() {
    this.initializeRoutes();
  }

  initializeRoutes() {
    this.router.get("/", home);
  }
}

export default new HomeRoutes().router;