import React, { Children, ReactNode, useEffect } from 'react';

import bg from '../../assets/treeBlock.jpeg';
import useWishStore from '../../wishstore';
import { getAllComment } from '../../service/CommentService';

interface CommentModalProps {
  showModal: boolean;
  onClose: () => void;
  className: string;
  children?: ReactNode;
}

const CommentModal: React.FC = ({
  showModal,
  onClose,
  className,
  children,
}) => {
  return (
    <div
      className={`absolute bg-[url('path-to-image')] w-[800px] h-[700px] ${className}`}
      style={{
        backgroundImage: `url(${bg})`,
        backgroundSize: 'cover',
      }}
    >
      {children}
      <button className="absolute" onClick={onClose}>
        닫기
      </button>
    </div>
  );
};

export default CommentModal;
