<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table-header">
	<tbody>
		<tr>
			<td class="table-subject" colspan="2">사업기안서</td>
		</tr>
		<tr>
			<td class="table-header-left">
				<table class="table-header-left-table">
					<tbody>
						<tr>
							<td class="table-header-left-table-left">기안자</td>
							<td class="table-header-left-table-right name">${login_name}</td>
						</tr>
						<tr>
							<td class="table-header-left-table-left">부서</td>
							<td class="table-header-left-table-right dept">${dept_name}</td>
						</tr>
						<tr>
							<td class="table-header-left-table-left">기안일</td>
							<td class="table-header-left-table-right date">${emp_date}</td>
						</tr>
						<tr>
							<td class="table-header-left-table-left">문서번호</td>
							<td class="table-header-left-table-right number"></td>
						</tr>
					</tbody>
				</table>
			</td>
			<td class="table-header-right">
				<div class="apv-sign">
					<table class="apv-sign-table">
						<tbody>
							<tr class="apv-sign-table-app">
								<th>신청</th>									
								<!-- 결재선 추가 -->
								<td class="apv-sign-table-right">
									<table>
										<tbody>
											<tr><td><span class="apv-sign-line-dept">${position_name}</span></td></tr>
											<tr><td><span class="apv-sign-line-name">${login_name}</span></td></tr>
											<tr class="last"><td><span class="apv-sign-line-date">${emp_date}</span></td></tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="apv-sign">
					<table class="apv-sign-table">
							<tbody>
								<tr class="apv-sign-table-tr">
									<th>승인</th>									
									<!-- 결재선 추가 -->
									<td class="apv-sign-table-right">
										<table>
											<tbody>
												<tr><td><span class="apv-sign-line-dept">&nbsp;</span></td></tr>
												<tr><td><span class="apv-sign-line-name">&nbsp;</span></td></tr>
												<tr class="last"><td><span class="apv-sign-line-date">&nbsp;</span></td></tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
					</table>
				</div>
			</td>
		</tr>
	</tbody>
</table>
<table class="table-content">
	<tbody>
		<tr>
				<td class="table-content-left">제목</td>
				<td class="table-content-right">
					<input type="text" name="apv_subject" class="form-control" placeholder="제목을 입력하세요." />
				</td>
		</tr>
		<tr>
				<td class="table-content-left">사업 개요</td>
				<td class="table-content-right">
					<textarea class="form-control" name="apv_overview" id="exampleFormControlTextarea1" placeholder="내용을 입력하세요." rows="3" style="resize: none"></textarea>
				</td>
		</tr>
		<tr>
				<td class="table-content-left">내용</td>
				<td class="table-content-right reason">
					<div>
			      <div id="snow-toolbar">
			        <span class="ql-formats">
			          <select class="ql-font"></select>
			          <select class="ql-size"></select>
			        </span>
			        <span class="ql-formats">
			          <button class="ql-bold"></button>
			          <button class="ql-italic"></button>
			          <button class="ql-underline"></button>
			          <button class="ql-strike"></button>
			        </span>
			        <span class="ql-formats">
			          <select class="ql-color"></select>
			          <select class="ql-background"></select>
			        </span>
			        <span class="ql-formats">
			          <button class="ql-script" value="sub"></button>
			          <button class="ql-script" value="super"></button>
			        </span>
			        <span class="ql-formats">
			          <button class="ql-header" value="1"></button>
			          <button class="ql-header" value="2"></button>
			          <button class="ql-blockquote"></button>
			          <button class="ql-code-block"></button>
			        </span>
			      </div>
			      <div id="snow-editor">
           </div>
				</div>
			</td>
		</tr>
	</tbody>
</table>
<input type="hidden" name="total_name" id="totalNames" />
<input type="hidden" name="apv_cnt" id="apvCnt" />
	  		