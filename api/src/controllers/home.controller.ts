import { Request, Response } from "express";

export function home(req: Request, res: Response): Response {
  return res.json({ message: "Snappier Sample API" });
}
