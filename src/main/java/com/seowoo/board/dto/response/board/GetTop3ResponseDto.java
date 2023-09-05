package com.seowoo.board.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.seowoo.board.common.response.ResponseCode;
import com.seowoo.board.common.response.ResponseMessage;
import com.seowoo.board.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetTop3ResponseDto extends ResponseDto {
     
     private List<BoardListResponseDto> top3;

     private GetTop3ResponseDto(String code, String message, List<BoardListResponseDto> top3) {
          super(code, message);
          this.top3 = top3;
     }

     public static ResponseEntity<GetTop3ResponseDto> success(List<BoardListResponseDto> top3) {
          GetTop3ResponseDto result = new GetTop3ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, top3);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }

}
