package com.refactor.workdemo;

/**
 * @author songyi
 * @date 2021-02-07 17:26
 * @Description:
 */
public class LongLongMethod {


    /** 这个恶心的方法
     * private List<FlowDetail.TaskNode> getFlowTask(AuditFlowProcessLog processLog) {
     *         String processId = String.valueOf(processLog.getProcessId());
     *         //task的审批人，未通过的 和已通过的不同
     *         List<TaskLogExtend> auditFlowTaskLogs = getTask(processId);
     *         // 审批任务节点所有涉及到的人员（包括申请人和节点审批人）
     *         List<String> userMisIds = auditFlowTaskLogs.stream().map(t -> {
     *             List<String> taskAssignerList = new ArrayList<>();
     *             if (StringUtils.isNotBlank(t.getAuditAssignReq())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssignReq().split(",")));
     *             }
     *             if (StringUtils.isNotBlank(t.getAuditAssign())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssign().split(",")));
     *             }
     *             return taskAssignerList;
     *         }).flatMap(t -> t.stream()).distinct().collect(toList());
     *         userMisIds.add(processLog.getApplyUser());
     *         List<DimEmployeeBean> empInfoList = dimEmployeeService.getEmpInfoListByMisListContainsLeave(userMisIds);
     *         Map<String, DimEmployeeBean> superiorMap = empInfoList.stream().collect(Collectors.toMap(DimEmployeeBean::getMisName, dimEmployeeBean -> dimEmployeeBean));
     *
     *         List<FlowDetail.TaskNode> result = new ArrayList<>();
     *         Map<String, String> userAvatarUrl = rpcCommonQueryService.getUserAvatarUrlList(userMisIds);
     *         //第一步是提交申请
     *         FlowDetail.TaskNode applyNode = new FlowDetail.TaskNode();
     *         applyNode.setStatus(3);
     *         applyNode.setModifyTime(CommonUtil.dateToYMDHMSString(auditFlowTaskLogs.get(0).getAuditStartTime()));
     *         List<FlowDetail.AssignerInfo> applyInfo = new ArrayList<>();
     *         DimEmployeeBean applyEmployee = superiorMap.get(processLog.getApplyUser());
     *         if (applyEmployee != null) {
     *             FlowDetail.AssignerInfo applyAssignerInfo = new FlowDetail.AssignerInfo();
     *             applyAssignerInfo.setAuditMis(processLog.getApplyUser());
     *             applyAssignerInfo.setAuditName(applyEmployee.getEmployeeName());
     *             applyAssignerInfo.setAvatarUrl(userAvatarUrl.get(processLog.getApplyUser()));
     *             applyInfo.add(applyAssignerInfo);
     *         }
     *         applyNode.setAssigners(applyInfo);
     *         applyNode.setTaskKey("apply");
     *         result.add(applyNode);
     *         int lastStatus = 3;
     *         for (TaskLogExtend taskLog : auditFlowTaskLogs) {
     *             FlowDetail.TaskNode taskNode = new FlowDetail.TaskNode();
     *             if (taskLog.getAddSign() > 0) {
     *                 //1表示被加签
     *                 taskNode.setAddSign(1);
     *                 //加签说明
     *                 taskNode.setAddSignComment(taskLog.getAddComment());
     *             } else {
     *                 //0表示未加签
     *                 taskNode.setAddSign(0);
     *             }
     *             //修改说明
     *             taskNode.setComment(taskLog.getReason());
     *             taskNode.setTaskId(Optional.ofNullable(taskLog.getId()).orElse(0L));
     *             taskNode.setNextTaskId(Optional.ofNullable(taskLog.getNextTask()).orElse(0L));
     *             // 节点状态 -2撤销申请 -1 已驳回 0 待审批 1 已通过 2 审批中 3提交申请
     *             Integer status = taskLog.getStatus();
     *             if (status == 0) {
     *                 //如果上一个审批了，当前未审批，现在就是审批中  或者上一个是提交申请
     *                 if (lastStatus == 1 || lastStatus == 3) {
     *                     taskNode.setStatus(2);
     *                     taskNode.setActive(true);
     *                     lastStatus = 0;
     *                 }
     *             } else {
     *                 taskNode.setStatus(status);
     *             }
     *             String assignUser = taskLog.getAuditAssignReq();
     *             // 任务被处理过，就取真实审批人；撤销时，操作人是申请人
     *             if (status != 0) {
     *                 assignUser = taskLog.getAuditAssign();
     *                 if (status == -2) {
     *                     assignUser = processLog.getApplyUser();
     *                 }
     *                 lastStatus = status;
     *             }
     *             if (taskLog.getAuditEndTime() != null) {
     *                 taskNode.setModifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditEndTime()));
     *             } else {
     *                 taskNode.setModifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditStartTime()));
     *             }
     *             taskNode.setTaskKey(taskNode.getTaskKey());
     *             if (StringUtils.isNotEmpty(assignUser)) {
     *                 String[] ids = assignUser.split(",");
     *                 List<FlowDetail.AssignerInfo> assignerInfos = new ArrayList<>();
     *                 for (String misid : ids) {
     *                     DimEmployeeBean employeeBean = superiorMap.get(misid);
     *                     if (employeeBean != null) {
     *                         FlowDetail.AssignerInfo assignerInfo = new FlowDetail.AssignerInfo();
     *                         assignerInfo.setAuditMis(misid);
     *                         assignerInfo.setAuditName(employeeBean.getEmployeeName());
     *                         assignerInfo.setAvatarUrl(userAvatarUrl.get(misid));
     *                         assignerInfos.add(assignerInfo);
     *                     }
     *                 }
     *                 taskNode.setAssigners(assignerInfos);
     *             }
     *             result.add(taskNode);
     *             //驳回或撤销下一个就不处理了
     *             if (status == -1 || status == -2) {
     *                 break;
     *             }
     *         }
     *
     *         return result;
     *     }
     */


    /**
     *  稍微重构了一下，还是不好，for循环修改临时遍历
     * private List<FlowDetail.TaskNode> getFlowTask(AuditFlowProcessLog processLog) {
     *         String processId = String.valueOf(processLog.getProcessId());
     *         //task的审批人，未通过的 和已通过的不同
     *         List<TaskLogExtend> auditFlowTaskLogs = getTask(processId);
     *         // 审批任务节点所有涉及到的人员（包括申请人和节点审批人）
     *         List<String> userMisIds = auditFlowTaskLogs.stream().map(t -> {
     *             List<String> taskAssignerList = new ArrayList<>();
     *             if (StringUtils.isNotBlank(t.getAuditAssignReq())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssignReq().split(",")));
     *             }
     *             if (StringUtils.isNotBlank(t.getAuditAssign())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssign().split(",")));
     *             }
     *             return taskAssignerList;
     *         }).flatMap(t -> t.stream()).distinct().collect(toList());
     *         userMisIds.add(processLog.getApplyUser());
     *         List<DimEmployeeBean> empInfoList = dimEmployeeService.getEmpInfoListByMisListContainsLeave(userMisIds);
     *         Map<String, DimEmployeeBean> superiorMap = empInfoList.stream().collect(Collectors.toMap(DimEmployeeBean::getMisName, dimEmployeeBean -> dimEmployeeBean));
     *
     *         List<FlowDetail.TaskNode> result = new ArrayList<>();
     *         Map<String, String> userAvatarUrl = rpcCommonQueryService.getUserAvatarUrlList(userMisIds);
     *         //第一步是提交申请
     *         result.add(getApplyNode(processLog, auditFlowTaskLogs, superiorMap, userAvatarUrl));
     *         result.addAll(getResult(auditFlowTaskLogs, superiorMap, userAvatarUrl));
     *         return result;
     *     }
     *
     *     private FlowDetail.TaskNode getApplyNode(AuditFlowProcessLog processLog, List<TaskLogExtend> auditFlowTaskLogs, Map<String, DimEmployeeBean> superiorMap, Map<String, String> userAvatarUrl) {
     *         FlowDetail.TaskNode.TaskNodeBuilder builder = FlowDetail.TaskNode.builder();
     *         builder.status(3)
     *         .modifyTime(CommonUtil.dateToYMDHMSString(auditFlowTaskLogs.get(0).getAuditStartTime()));
     *         List<FlowDetail.AssignerInfo> applyInfo = new ArrayList<>();
     *         DimEmployeeBean applyEmployee = superiorMap.get(processLog.getApplyUser());
     *         if (applyEmployee != null) {
     *             FlowDetail.AssignerInfo applyAssignerInfo = new FlowDetail.AssignerInfo();
     *             applyAssignerInfo.setAuditMis(processLog.getApplyUser());
     *             applyAssignerInfo.setAuditName(applyEmployee.getEmployeeName());
     *             applyAssignerInfo.setAvatarUrl(userAvatarUrl.get(processLog.getApplyUser()));
     *             applyInfo.add(applyAssignerInfo);
     *         }
     *         builder.assigners(applyInfo);
     *         return builder.build();
     *     }
     *
     *     private List<FlowDetail.TaskNode> getResult(List<TaskLogExtend> auditFlowTaskLogs, Map<String, DimEmployeeBean> superiorMap, Map<String, String> userAvatarUrl) {
     *         List<FlowDetail.TaskNode> result = new ArrayList<>();
     *         final int APPLY_STATUS = 3;
     *         final int IN_APPROVING_STATUS = 2;
     *         final int APPROVED_STATUS = 1;
     *         final int WAIT_APPROVE_STATUS = 0;
     *         final int REJECTED_STATUS = -1;
     *         final int CANCEL_STATUS = -2;
     *         int lastStatus = APPLY_STATUS;
     *         for (TaskLogExtend taskLog : auditFlowTaskLogs) {
     *             FlowDetail.TaskNode.TaskNodeBuilder builder = FlowDetail.TaskNode.builder();
     *             //1加签处理
     *             builder.addSign(taskLog.getAddSign()).addSignComment(taskLog.getAddComment());
     *             //修改说明
     *             builder.comment(taskLog.getReason())
     *                     .taskId(Optional.ofNullable(taskLog.getId()).orElse(0L))
     *                     .nextTaskId(Optional.ofNullable(taskLog.getNextTask()).orElse(0L));
     *
     *             // 节点状态 -2撤销申请 -1 已驳回 0 待审批 1 已通过 2 审批中 3提交申请
     *             int status = taskLog.getStatus();
     *             todo 直接使用 taskLog的 active字段就行了，就可以不用 status标记了
     *             if (status == WAIT_APPROVE_STATUS && (lastStatus == APPROVED_STATUS || lastStatus == APPLY_STATUS)) {
     *                 //如果上一个审批了，当前未审批，现在就是审批中  或者上一个是提交申请
     *                 builder.status(IN_APPROVING_STATUS).active(true);
     *             } else {
     *                 builder.status(status);
     *             }
     *             lastStatus = status;
     *
     *             if (taskLog.getAuditEndTime() != null) {
     *                 builder.modifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditEndTime()));
     *             } else {
     *                 builder.modifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditStartTime()));
     *             }
     *
     *             String assignUser = StringUtils.isEmpty(taskLog.getAuditAssign()) ? taskLog.getAuditAssignReq() : taskLog.getAuditAssign();
     *             builder.assigners(getAssignInfo(superiorMap, userAvatarUrl, assignUser));
     *             result.add(builder.build());
     *             //驳回或撤销下一个就不处理了
     *             if (status == REJECTED_STATUS || status == CANCEL_STATUS) {
     *                 break;
     *             }
     *         }
     *         return result;
     *     }
     *
     *     private List<FlowDetail.AssignerInfo> getAssignInfo(Map<String, DimEmployeeBean> superiorMap, Map<String, String> userAvatarUrl, String assignUser) {
     *         if(StringUtils.isEmpty(assignUser)){
     *             return Collections.emptyList();
     *         }
     *         String[] ids = assignUser.split(",");
     *         List<FlowDetail.AssignerInfo> assignerInfos = new ArrayList<>();
     *         for (String misid : ids) {
     *             DimEmployeeBean employeeBean = superiorMap.get(misid);
     *             if (employeeBean != null) {
     *                 FlowDetail.AssignerInfo assignerInfo = new FlowDetail.AssignerInfo();
     *                 assignerInfo.setAuditMis(misid);
     *                 assignerInfo.setAuditName(employeeBean.getEmployeeName());
     *                 assignerInfo.setAvatarUrl(userAvatarUrl.get(misid));
     *                 assignerInfos.add(assignerInfo);
     *             }
     *         }
     *         return assignerInfos;
     *     }
     */
}
