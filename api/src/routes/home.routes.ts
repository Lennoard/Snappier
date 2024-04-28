import { Router } from "express";
import { home } from "../controllers/home.controller"

class HomeRoutes {
  router = Router();

  constructor() {
    this.intializeRoutes();
  }

  intializeRoutes() {
    this.router.get("/", home);
  }
}

export default new HomeRoutes().router;