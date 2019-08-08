package com.dreamworks.sms.score.dto;

import java.io.Serializable;
import java.util.List;

import com.dreamworks.sms.score.dto.ScoreInfoQueryDto.ScoreInfoQueryDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ScoreInfoListDto implements Serializable{

	private List<ScoreInfoDto> list;
}
