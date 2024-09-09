export interface CreatedComment {
  content: string;
  wishId: number;
  //registrationDate,deleted_at,is_deleted 이건 디비에서 관리 생성시에는 필요X
}
