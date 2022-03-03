package Entities;

import java.util.Date;

public class Article {
  private int IdArticle;
  private String TitreArticle;
  private String DescriptionArticle;
  private Date DateArticle;
  private String ImageArticle;
  private int idArticle;

  public Article() {}

  public Article(String TitreArticle, String DescriptionArticle,
                 String ImageArticle) {

    this.TitreArticle = TitreArticle;
    this.DescriptionArticle = DescriptionArticle;
    this.ImageArticle = ImageArticle;
  }

  public Article(int IdArticle, String TitreArticle, String DescriptionArticle,
                 String ImageArticle) {
    this.IdArticle = IdArticle;
    this.TitreArticle = TitreArticle;
    this.DescriptionArticle = DescriptionArticle;
    this.ImageArticle = ImageArticle;
  }

  public int getIdArticle() { return IdArticle; }

  public void setIdArticle(int IdArticle) { this.IdArticle = IdArticle; }

  public String getTitreArticle() { return TitreArticle; }

  public void setTitreArticle(String TitreArticle) {
    this.TitreArticle = TitreArticle;
  }

  public String getDescriptionArticle() { return DescriptionArticle; }

  public void setDescriptionArticle(String DescriptionArticle) {
    this.DescriptionArticle = DescriptionArticle;
  }

  public Date getDateArticle() { return DateArticle; }

  public void setDateArticle(Date DateArticle) {
    this.DateArticle = DateArticle;
  }

  public String getImageArticle() { return ImageArticle; }

  public void setImageArticle(String ImageArticle) {
    this.ImageArticle = ImageArticle;
  }

  @Override
  public String toString() {
    return "Article{"
        + "IdArticle=" + IdArticle + ", TitreArticle='" + TitreArticle + '\'' +
        ", DescriptionArticle='" + DescriptionArticle + '\'' +
        ", DateArticle='" + DateArticle + '\'' + ", ImageArticle='" +
        ImageArticle + '\'' + '}';
  }
}
