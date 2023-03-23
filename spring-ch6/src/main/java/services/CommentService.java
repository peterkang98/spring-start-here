package services;

import aspects.ToLog;
import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
  private Logger logger = Logger.getLogger(CommentService.class.getName());
  @ToLog
  public String publishComment(Comment comment){
    logger.info("publishing comment: "+comment.getText());
    return "SUCCESS";
  }
}
